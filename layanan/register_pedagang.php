<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){

		require_once ('setting_server.php');
		// $id_mhs = $_POST['id_mhs'];
		$nama = $_POST['nama'];
		$alamat = $_POST['alamat'];
		$email = $_POST['email'];
		$no_telepon = $_POST['no_telepon'];
		$role = "Pedagang";
		$username = $_POST['username'];
		$password = $_POST ['password'];

		$sql ="INSERT INTO user (nama,alamat, email, no_telepon,role,username, password) VALUES ('$nama','$alamat','$email','$no_telepon','$role','$username', '$password')";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	}
	?>