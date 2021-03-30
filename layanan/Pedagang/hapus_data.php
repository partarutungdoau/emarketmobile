<?php 
$id_produk = $_POST['id_produk'];
	require_once ('../setting_server.php');

		$sql ="DELETE from produk where id = $id_produk;";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	
?>