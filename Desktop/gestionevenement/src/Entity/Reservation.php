<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservation
 *
 * @ORM\Table(name="reservation")
 * @ORM\Entity
 */
class Reservation
{
    /**
     * @var int
     *
     * @ORM\Column(name="idClient", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idclient;

    /**
     * @var int
     *
     * @ORM\Column(name="idEvent", type="integer", nullable=false)
     */
    private $idevent;

    /**
     * @var string
     *
     * @ORM\Column(name="nomClient", type="string", length=255, nullable=false)
     */
    private $nomclient;

    /**
     * @var string
     *
     * @ORM\Column(name="prenomClient", type="string", length=255, nullable=false)
     */
    private $prenomclient;

    public function getIdclient(): ?int
    {
        return $this->idclient;
    }

    public function getIdevent(): ?int
    {
        return $this->idevent;
    }

    public function setIdevent(int $idevent): self
    {
        $this->idevent = $idevent;

        return $this;
    }

    public function getNomclient(): ?string
    {
        return $this->nomclient;
    }

    public function setNomclient(string $nomclient): self
    {
        $this->nomclient = $nomclient;

        return $this;
    }

    public function getPrenomclient(): ?string
    {
        return $this->prenomclient;
    }

    public function setPrenomclient(string $prenomclient): self
    {
        $this->prenomclient = $prenomclient;

        return $this;
    }


}
