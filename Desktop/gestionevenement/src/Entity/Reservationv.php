<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservationv
 *
 * @ORM\Table(name="reservationv", indexes={@ORM\Index(name="Id", columns={"Id"})})
 * @ORM\Entity
 */
class Reservationv
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdR", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idr;

    /**
     * @var int
     *
     * @ORM\Column(name="NB_personnes", type="integer", nullable=false)
     */
    private $nbPersonnes;

    /**
     * @var string
     *
     * @ORM\Column(name="Date", type="string", length=30, nullable=false)
     */
    private $date;

    /**
     * @var \Voyage
     *
     * @ORM\ManyToOne(targetEntity="Voyage")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Id", referencedColumnName="Id")
     * })
     */
    private $id;

    public function getIdr(): ?int
    {
        return $this->idr;
    }

    public function getNbPersonnes(): ?int
    {
        return $this->nbPersonnes;
    }

    public function setNbPersonnes(int $nbPersonnes): self
    {
        $this->nbPersonnes = $nbPersonnes;

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

    public function getId(): ?Voyage
    {
        return $this->id;
    }

    public function setId(?Voyage $id): self
    {
        $this->id = $id;

        return $this;
    }


}
