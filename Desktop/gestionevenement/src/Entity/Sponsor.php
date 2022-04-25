<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Sponsor
 *
 * @ORM\Table(name="sponsor", uniqueConstraints={@ORM\UniqueConstraint(name="idS_2", columns={"idS"}), @ORM\UniqueConstraint(name="idS", columns={"idS"})})
 * @ORM\Entity
 */
class Sponsor
{
    /**
     * @var int
     *
     * @ORM\Column(name="idS", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ids;

    /**
     * @var string
     *
     * @ORM\Column(name="prenomS", type="string", length=255, nullable=false)
     */
    private $prenoms;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionS", type="string", length=255, nullable=false)
     */
    private $descriptions;

    /**
     * @var string
     *
     * @ORM\Column(name="nomS", type="string", length=255, nullable=false)
     */
    private $noms;

    /**
     * @var string
     *
     * @ORM\Column(name="imageS", type="string", length=255, nullable=false)
     */
    private $images;

    public function getIds(): ?int
    {
        return $this->ids;
    }

    public function getPrenoms(): ?string
    {
        return $this->prenoms;
    }

    public function setPrenoms(string $prenoms): self
    {
        $this->prenoms = $prenoms;

        return $this;
    }

    public function getDescriptions(): ?string
    {
        return $this->descriptions;
    }

    public function setDescriptions(string $descriptions): self
    {
        $this->descriptions = $descriptions;

        return $this;
    }

    public function getNoms(): ?string
    {
        return $this->noms;
    }

    public function setNoms(string $noms): self
    {
        $this->noms = $noms;

        return $this;
    }

    public function getImages(): ?string
    {
        return $this->images;
    }

    public function setImages(string $images): self
    {
        $this->images = $images;

        return $this;
    }


}
