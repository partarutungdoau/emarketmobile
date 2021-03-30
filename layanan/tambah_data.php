<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		// $id_mhs = $_POST['id_mhs'];
		$nama_produk = $_POST['nama_produk'];
		$kategori_produk = $_POST ['kategori_produk'];
		$harga = $_POST ['harga'];
		$deskripsi = $_POST ['deskripsi'];
		$gambar = $_POST ['gambar'];

	require_once ('setting_server.php');

		$sql ="INSERT INTO produk (nama_produk, kategori_produk, harga, deskripsi, gambar) VALUES ('$nama_produk', '$kategori_produk', '$harga','$deskripsi','$gambar')";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	}
	?>