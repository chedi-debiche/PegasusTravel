<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Form\Evenement1Type;
use App\Repository\EvenementRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\JsonResponse;

/**
 * @Route("/evenement/back")
 */
class EvenementBackController extends AbstractController
{
    /**
     * @Route("/", name="app_evenement_back_index", methods={"GET"})
     */
    public function index(EntityManagerInterface $entityManager ,EvenementRepository $repo ): Response
    {
        $upcoming =$repo->select();
        $evenements = $entityManager
            ->getRepository(Evenement::class)
            ->findAll();
        return $this->render('evenement_back/index.html.twig', [
            'evenements' => $evenements,
            'coming'    => $upcoming ,
        ]);
    }
    /**
     * @Route("/new", name="app_evenement_back_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $evenement = new Evenement();
        $form = $this->createForm(Evenement1Type::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($evenement);
            $entityManager->flush();

            return $this->redirectToRoute('app_evenement_back_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('evenement_back/new.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idevent}", name="app_evenement_back_show", methods={"GET"})
     */
    public function show(Evenement $evenement): Response
    {
        return $this->render('evenement_back/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }

    /**
     * @Route("/{idevent}/edit", name="app_evenement_back_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Evenement $evenement, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(Evenement1Type::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_evenement_back_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('evenement_back/edit.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idevent}", name="app_evenement_back_delete", methods={"POST"})
     */
    public function delete(Request $request, EvenementRepository $repo ,Evenement $evenement, EntityManagerInterface $entityManager): Response
    {

        if ($this->isCsrfTokenValid('delete'.$evenement->getIdevent(), $request->request->get('_token'))) {
            $entityManager->remove($evenement);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_evenement_back_index', [], Response::HTTP_SEE_OTHER);
    }

    /**
     * @Route("/r/search_back1", name="search_back1",methods={"GET"})
     */

    public function search_back1(Request $request,EvenementRepository $evenementRepository): Response
    {

        $requestString = $request->get('searchValue');
        $Reclamations = $evenementRepository->findTeamwithNumber($requestString);
        $responseArray = [];
        $idx = 0;

        foreach ($Reclamations as $Evenement) {
            $temp = [
                'nomevent' => $Evenement->getNomevent(),
                'prixevent' => $Evenement->getPrixevent(),
                'date' => $Evenement->getDate()->format(' Y-m-d'),

            ];

            $responseArray[$idx++] = $temp;
        }
        return new JsonResponse($responseArray);
    }
    /**
     * @Route("DOWNtriEQUIPE", name="DOWNtriEQUIPE",options={"expose"=true})
     */
    public function DOWNtriEQUIPE(Request $request,EvenementRepository $repository): JsonResponse
    {

        $UPorDOWN=$request->get('order');
        $Reclamations=$repository->DescEvenementSearch($UPorDOWN);
        $responseArray = [];
        $idx = 0;
        foreach ($Reclamations as $Evenement){
            $temp =  [
                'nomevent' => $Evenement->getNomevent(),
                'prixevent' => $Evenement->getPrixevent(),
                'date' => $Evenement->getDate()->format(' Y-m-d'),
            ];

            $responseArray[$idx++] = $temp;

        }
        return new JsonResponse($responseArray);
    }

    /**
     * @Route("UPtriEQUIPE", name="UPtriEQUIPE",options={"expose"=true})
     */
    public function UPtriEQUIPE(Request $request,EvenementRepository $repository): JsonResponse
    {


        $UPorDOWN=$request->get('order');
        $Reclamations=$repository->AscEvenementSearch($UPorDOWN);
        $responseArray = [];
        $idx = 0;
        foreach ($Reclamations as $Evenement){
            $temp = [
                'nomevent' => $Evenement->getNomevent(),
                'prixevent' => $Evenement->getPrixevent(),
                'date' => $Evenement->getDate()->format(' Y-m-d'),
            ];
            $responseArray[$idx++] = $temp;
        }
        return new JsonResponse($responseArray);
    }
}
