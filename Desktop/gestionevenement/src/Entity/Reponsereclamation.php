<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reponsereclamation
 *
 * @ORM\Table(name="reponsereclamation", indexes={@ORM\Index(name="numero", columns={"numero"})})
 * @ORM\Entity
 */
class Reponsereclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdRep", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idrep;

    /**
     * @var string
     *
     * @ORM\Column(name="Reponse", type="string", length=255, nullable=false)
     */
    private $reponse;

    /**
     * @var \Reclamation
     *
     * @ORM\ManyToOne(targetEntity="Reclamation")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="numero", referencedColumnName="numero")
     * })
     */
    private $numero;

    public function getIdrep(): ?int
    {
        return $this->idrep;
    }

    public function getReponse(): ?string
    {
        return $this->reponse;
    }

    public function setReponse(string $reponse): self
    {
        $this->reponse = $reponse;

        return $this;
    }

    public function getNumero(): ?Reclamation
    {
        return $this->numero;
    }

    public function setNumero(?Reclamation $numero): self
    {
        $this->numero = $numero;

        return $this;
    }


}
