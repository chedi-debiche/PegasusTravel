<?php

namespace App\Repository;
use App\Entity\Evenement;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\Intl\DateFormatter\DateFormat\DayOfYearTransformer;
use Symfony\Component\Serializer\Normalizer\DateIntervalNormalizer;
use Symfony\Component\Validator\Constraints\Date;

class EvenementRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Evenement::class);
    }
    public function Order()
    {
        $em = $this->getEntityManager();
        $query = $em->createQuery('select m from App\Entity\Evenement m order by m.prixevent DESC');
        return $query->getResult();
    }
    public function findByNom($nom)
    {
        $em = $this->getEntityManager();
        $query = $em->createQuery('select m from App\Entity\Evenement m where m.nomevent =:nomevent')
            ->setParameter('nomevent', $nom);
        return $query->getResult();
    }
    public function Filter($prixevent)
    {
        $em = $this->getEntityManager();
        $query = $em->createQuery('select m from App\Entity\Evenement m where m.prixevent <:prixevent')
            ->setParameter('prixevent', $prixevent);
        return $query->getResult();
    }
    public function select()
    {  $time = new \DateTime() ;
        $time->format('H:i:s \O\n Y-m-d');
        $time1=new \DateTime();
        $time1->add( date_interval_create_from_date_string('10 days'));
        $time1->format('H:i:s \O\n Y-m-d');
        $em = $this->getEntityManager();
        $query = $em->createQuery('select m from App\Entity\Evenement m where m.date between ?1 and ?2')
            ->setParameter('1',$time)
            ->setParameter('2',$time1);

        return $query->getResult();
    }
    public function findTeamwithNumber($num){
        return $this->createQueryBuilder('Evenement')
            ->where('Evenement.nomevent LIKE :nom')
            ->setParameter('nom', '%'.$num.'%')
            ->getQuery()
            ->getResult();
    }
    public function DescEvenementSearch($order){
        $em = $this->getEntityManager();

        $query = $em->createQuery('SELECT e FROM App\Entity\Evenement e order by e.date DESC ');
        return $query->getResult();
    }

    public function AscEvenementSearch($order){
        $em = $this->getEntityManager();

        $query = $em->createQuery('SELECT e FROM App\Entity\Evenement e order by e.date ASC  ');
        return $query->getResult();
    }
    public function AutoDelete(){
        $time = new \DateTime() ;
        $time->format('H:i:s \O\n Y-m-d');
        $time1=new \DateTime();
        $time1->sub( date_interval_create_from_date_string('60 days'));
        $time1->format('H:i:s \O\n Y-m-d');
        $em = $this->getEntityManager();
        $query = $em->createQuery('select m from App\Entity\Evenement m where m.date between ?1 and ?2')
            ->setParameter('1',$time)
            ->setParameter('2',$time1);
        return $query->getResult();

    }

}