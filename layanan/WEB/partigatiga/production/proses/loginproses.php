<?php

session_start();

$connect = new mysqli("localhost", "root", "", "partigatiga");

	if(isset($_POST['login']))
         {
          $ambil = $koneksi->query("SELECT * FROM administrator WHERE username='$_POST[username]' AND password = '$_POST[password]'");
          $yangcocok = $get->num_rows;
          if($yangcocok==1)
          {
            $_SESSION['mahasiswa']=$get->fetch_assoc();
             // echo "<div class='alert alert-danger'>Login Sukses</div>";
            echo "<meta http-equiv='refresh' content='1;url=../index.php'; >";
          } 
          else{
            // echo "<div class='alert alert-danger'>Login Gagal</div>";
            echo "<meta http-equiv='refresh' content='1;url=../login.php'; >";
          }
        }

?>
