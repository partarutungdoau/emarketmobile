<?php
	include "connect.php";
	$get = $connect->query("SELECT * FROM user WHERE id_user = '$_GET[id]'");
	$pecah = $get->fetch_assoc();
	$nama_gambar = $pecah['gambar'];

	// if(file_exists("../images/$nama_gambar"))
	// {
	// 	unlink("../images/$nama_gambar");
	// }

	$connect->query("DELETE FROM user WHERE id_user='$_GET[id]'");

	echo "<script>alert('User Berhasil Dihapus');</script>";
	echo "<script>location='index.php?halaman=pelanggan';</script>";
?>