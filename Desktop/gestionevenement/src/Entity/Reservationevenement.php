<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Reservationevenement
 *
 * @ORM\Table(name="reservationevenement", indexes={@ORM\Index(name="idEvent", columns={"idEvent"})})
 * @ORM\Entity
 */
class Reservationevenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="idRE", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idre;

    /**
     * @var string
     *@Assert\NotBlank(message="le champ nom doit etre non vide")
     * @ORM\Column(name="nomRE", type="string", length=255)
     */
    private $nomre;

    /**
     * @Assert\NotBlank(message="le date prix doit etre non vide")
     * @var \DateTime
     *
     * @ORM\Column(name="dateRE", type="date")
     */
    private $datere;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idEvent", referencedColumnName="idEvent")
     * })
     */
    private $idevent;

    public function getIdre():?int
    {
        return $this->idre;
    }

    public function getNomre(): ?string
    {
        return $this->nomre;
    }

    public function setNomre(string $nomre): self
    {
        $this->nomre = $nomre;

        return $this;
    }

    public function getDatere(): ?\DateTimeInterface
    {
        return $this->datere;
    }

    public function setDatere(\DateTimeInterface $datere): self
    {
        $this->datere = $datere;

        return $this;
    }

    public function getIdevent(): ?Evenement
    {
        return $this->idevent;
    }

    public function setIdevent(?Evenement $idevent): self
    {
        $this->idevent = $idevent;

        return $this;
    }


}
