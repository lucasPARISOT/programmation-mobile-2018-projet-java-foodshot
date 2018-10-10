<?php
/**
 * Created by PhpStorm.
 * User: Marc-Antoine
 * Date: 08/10/2018
 * Time: 22:15
 */

// headers requis
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

require_once '../config/Connexion.php';
require_once '../objets/Utilisateur.php';

use ProjetMobileAPI\Connexion;
use ProjetMobileAPI\Utilisateur;

$bdd = Connexion::get()->connect();

$utilisateur = new Utilisateur($bdd);

// récupération des données transmises en POST
$data = json_decode(file_get_contents("php://input"));

// set product property values
$utilisateur->nom = $data->nom;
$utilisateur->pseudonyme = $data->pseudonyme;
$utilisateur->mdp_hash = $data->mdp_hash;

// create the product
if($utilisateur->creer()){
    echo '{';
    echo '"message": "L\'utilisateur a été créé."';
    echo '}';
}

// if unable to create the product, tell the user
else{
    echo '{';
    echo '"message": "Impossible de créer l\'utilisateur."';
    echo '}';
}
?>