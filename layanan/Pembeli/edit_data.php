<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id_produk = $_POST['id_produk'];
		$nama_produk = $_POST['nama_produk'];
		$kategori_produk = $_POST ['kategori_produk'];
		$harga = $_POST ['harga'];
		$deskripsi = $_POST ['deskripsi'];
		$gambar = $_POST ['gambar'];

	require_once ('setting_server.php');

		$sql ="UPDATE produk SET nama_produk ='$nama_produk', kategori_produk='$kategori_produk', harga='$harga', deskripsi='$deskripsi', gambar='$gambar'    where id_produk = $id_produk;";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	}

	if($_SERVER['REQUEST_METHOD']=='GET'){
		$id_produk = $_POST['id_produk'];
		$nama_produk = $_POST['nama_produk'];
		$kategori_produk = $_POST ['kategori_produk'];
		$harga = $_POST ['harga'];
		$deskripsi = $_POST ['deskripsi'];
		$gambar = $_POST ['gambar'];


	require_once ('setting_server.php');

		$sql ="UPDATE produk SET nama_produk ='$nama_produk', kategori_produk='$kategori_produk', harga='$harga', deskripsi='$deskripsi', gambar='$gambar'    where id_produk = $id_produk;";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	}
	?>