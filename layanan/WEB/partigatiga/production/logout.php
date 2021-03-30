<?php
session_start();
unset($_SESSION['administrator']);
echo "<script>alert('Anda Berhasil Logout');</script>";
echo "<script>location='index.php?halaman=login';</script>";
?>