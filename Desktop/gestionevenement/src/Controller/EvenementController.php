<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Form\EvenementType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Dompdf\Dompdf;
use Dompdf\Options ;
use App\Repository\EvenementRepository;
use Knp\Component\Pager\PaginatorInterface;

/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{
    /**
     * @Route("/", name="app_evenement_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager ,Request $request ,PaginatorInterface $paginator): Response
    {
        $evenements = $entityManager
            ->getRepository(Evenement::class)
            ->findAll();
        $evenement = $paginator->paginate(
            $evenements, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            6 // Nombre de résultats par page
        );
        return $this->render('evenement/index.html.twig', [
            'evenement' => $evenement,
        ]);
    }

    /**
     * @Route("/new", name="app_evenement_new")
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($evenement);
            $entityManager->flush();

            return $this->redirectToRoute('app_evenement_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('evenement/new.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idevent}", name="app_evenement_show", methods={"GET"})
     */
    public function show(Evenement $evenement): Response
    {
        return $this->render('evenement/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }

    /**
     * @Route("/{idevent}/edit", name="app_evenement_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Evenement $evenement, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_evenement_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('evenement/edit.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idevent}", name="app_evenement_delete", methods={"POST"})
     */
    public function delete(Request $request, Evenement $evenement, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete' . $evenement->getIdevent(), $request->request->get('_token'))) {
            $entityManager->remove($evenement);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_evenement_index', [], Response::HTTP_SEE_OTHER);
    }

    /**
     * @Route("imp", name="impr")
     */
    public function imprimer(EvenementRepository $repository, EntityManagerInterface $entityManager): Response

    {
        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);

        $evenements = $entityManager
            ->getRepository(Evenement::class)
            ->findAll();

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('evenement/pdf.html.twig', [
            'evenement' => $evenements,
        ]);
        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (inline view)
        $dompdf->stream("Liste  Evenement.pdf", [
            "Attachment" => true

        ]);
    }

    /**
     * @param ProduitRepository $repository
     * @return Response
     * @Route ("tri",name="tri")
     */
    function Order(EvenementRepository  $repository,Request $request, PaginatorInterface $paginator){
        $donnees=$repository->Order();
        $evenement = $paginator->paginate(
            $donnees, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            6 // Nombre de résultats par page
        );
        return $this->render("evenement/index.html.twig",[
            'evenement'=>$evenement

        ]);
    }
    /**
     * @Route("filter", name="filter")
     */
    public function Filter( EvenementRepository $repo ,Request $request ,PaginatorInterface $paginator) : Response
    {
        $prix = $_GET['prix'];
        $data = $repo->Filter($prix);
        $evnement = $paginator->paginate(
            $data, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            6 // Nombre de résultats par page
        );

        return $this->render('evenement/index.html.twig', [
            'evenement' => $evnement
        ]);  }
}
