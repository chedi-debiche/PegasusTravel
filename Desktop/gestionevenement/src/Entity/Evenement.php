<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Evenement
 *
 * @ORM\Table(name="evenement", uniqueConstraints={@ORM\UniqueConstraint(name="idEvent", columns={"idEvent"})})
 * @ORM\Entity
 */
class Evenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="idEvent", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idevent;

    /**
* @Assert\NotBlank(message="le champ nom doit etre non vide")
* @Assert\Length(
*      min = 3,
*      minMessage = "doit etre >=3 ",)
     * @var string
     *
     * @ORM\Column(name="nomEvent", type="string", length=255, nullable=false)
     */
    private $nomevent;

    /**  @Assert\NotBlank(message="le champ prix doit etre non vide")
     * @var float
     *
     * @ORM\Column(name="prixEvent", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixevent;

    /** @Assert\NotBlank(message="le champ date:doit etre non vide")
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    public function getIdevent(): ?int
    {
        return $this->idevent;
    }

    public function getNomevent(): ?string
    {
        return $this->nomevent;
    }

    public function setNomevent(string $nomevent): self
    {
        $this->nomevent = $nomevent;

        return $this;
    }

    public function getPrixevent(): ?float
    {
        return $this->prixevent;
    }

    public function setPrixevent(float $prixevent): self
    {
        $this->prixevent = $prixevent;

        return $this;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }



}
