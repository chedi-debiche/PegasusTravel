<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservationm
 *
 * @ORM\Table(name="reservationm", indexes={@ORM\Index(name="maisonH_reservationm", columns={"id_maison"})})
 * @ORM\Entity
 */
class Reservationm
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_res", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idRes;

    /**
     * @var int
     *
     * @ORM\Column(name="nb_chambre", type="integer", nullable=false)
     */
    private $nbChambre;

    /**
     * @var int
     *
     * @ORM\Column(name="nb_personne", type="integer", nullable=false)
     */
    private $nbPersonne;

    /**
     * @var string
     *
     * @ORM\Column(name="date", type="string", length=50, nullable=false)
     */
    private $date;

    /**
     * @var \Maisonh
     *
     * @ORM\ManyToOne(targetEntity="Maisonh")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_maison", referencedColumnName="id_maison")
     * })
     */
    private $idMaison;

    public function getIdRes(): ?int
    {
        return $this->idRes;
    }

    public function getNbChambre(): ?int
    {
        return $this->nbChambre;
    }

    public function setNbChambre(int $nbChambre): self
    {
        $this->nbChambre = $nbChambre;

        return $this;
    }

    public function getNbPersonne(): ?int
    {
        return $this->nbPersonne;
    }

    public function setNbPersonne(int $nbPersonne): self
    {
        $this->nbPersonne = $nbPersonne;

        return $this;
    }

    public function getDate(): ?string
    {
        return $this->date;
    }

    public function setDate(string $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getIdMaison(): ?Maisonh
    {
        return $this->idMaison;
    }

    public function setIdMaison(?Maisonh $idMaison): self
    {
        $this->idMaison = $idMaison;

        return $this;
    }


}
