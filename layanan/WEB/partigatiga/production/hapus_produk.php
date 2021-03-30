<?php
	include "connect.php";
	$get = $connect->query("SELECT * FROM produk WHERE id_produk = '$_GET[id]'");
	$pecah = $get->fetch_assoc();
	$nama_gambar = $pecah['gambar'];

	if(file_exists("../images/$nama_gambar"))
	{
		unlink("../images/$nama_gambar");
	}

	$connect->query("DELETE FROM produk WHERE id_produk='$_GET[id]'");

	echo "<script>alert('Produk Berhasil Dihapus');</script>";
	echo "<script>location='index.php?halaman=produk';</script>";
?>