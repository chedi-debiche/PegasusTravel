<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Maisonh
 *
 * @ORM\Table(name="maisonh")
 * @ORM\Entity
 */
class Maisonh
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_maison", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idMaison;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=50, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="localisation", type="string", length=1000, nullable=false)
     */
    private $localisation;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=1000, nullable=false)
     */
    private $description;

    /**
     * @var float
     *
     * @ORM\Column(name="prix", type="float", precision=10, scale=0, nullable=false)
     */
    private $prix;

    /**
     * @var string
     *
     * @ORM\Column(name="image_maison", type="string", length=100, nullable=false)
     */
    private $imageMaison;

    public function getIdMaison(): ?int
    {
        return $this->idMaison;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getLocalisation(): ?string
    {
        return $this->localisation;
    }

    public function setLocalisation(string $localisation): self
    {
        $this->localisation = $localisation;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getPrix(): ?float
    {
        return $this->prix;
    }

    public function setPrix(float $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getImageMaison(): ?string
    {
        return $this->imageMaison;
    }

    public function setImageMaison(string $imageMaison): self
    {
        $this->imageMaison = $imageMaison;

        return $this;
    }


}
