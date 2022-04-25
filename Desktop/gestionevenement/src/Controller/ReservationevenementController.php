<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Entity\Reservationevenement;
use App\Form\ReservationevenementType;
use Doctrine\ORM\EntityManagerInterface;
use phpDocumentor\Reflection\Types\Integer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\EvenementRepository ;
use App\Notification\NouveauCompteNotification;
/**
 * @Route("/reservationevenement")
 */
class ReservationevenementController extends AbstractController
{
    /**
     * @var NouveauCompteNotification
     */
    private $notify_creation;

    public function __construct(NouveauCompteNotification $notify_creation)
    {
        $this->notify_creation = $notify_creation;
    }
    /**
     * @Route("/", name="app_reservationevenement_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager): Response
    {
        $reservationevenements = $entityManager
            ->getRepository(Reservationevenement::class)
            ->findAll();

        return $this->render('reservationevenement/index.html.twig', [
            'reservationevenements' => $reservationevenements,
        ]);
    }

   /**
    *  @param Integer $idevent
    * @param EvenementRepository $rep
     * @Route("/{idevent}/new", name="app_reservationevenement_new", methods={"GET", "POST"})
     */
        public function new(Request $request, EntityManagerInterface $entityManager , $idevent,EvenementRepository $rep,Evenement $evenement): Response
    {   $event = $rep->find($idevent);
        $reservationevenement = new Reservationevenement();
        $form = $this->createForm(ReservationevenementType::class, $reservationevenement);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
           $reservationevenement->setIdevent($event);
            $entityManager->persist($reservationevenement);
            $entityManager->flush();
            $this->notify_creation->notify();
            $this->addFlash("success","votre réservation a été ajoutée avec succées");
            return $this->redirectToRoute('app_evenement_index', [], Response::HTTP_SEE_OTHER);
        }
        return $this->render('reservationevenement/new.html.twig', [
            'reservationevenement' => $reservationevenement,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @Route("/{idre}", name="app_reservationevenement_show", methods={"GET"})
     */
    public function show(Reservationevenement $reservationevenement): Response
    {
        return $this->render('reservationevenement/show.html.twig', [
            'reservationevenement' => $reservationevenement,
        ]);
    }

    /**
     * @Route("/{idre}/edit", name="app_reservationevenement_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Reservationevenement $reservationevenement, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ReservationevenementType::class, $reservationevenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_reservationevenement_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reservationevenement/edit.html.twig', [
            'reservationevenement' => $reservationevenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idre}", name="app_reservationevenement_delete", methods={"POST"})
     */
    public function delete(Request $request, Reservationevenement $reservationevenement, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reservationevenement->getIdre(), $request->request->get('_token'))) {
            $entityManager->remove($reservationevenement);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_reservationevenement_index', [], Response::HTTP_SEE_OTHER);
    }
}
