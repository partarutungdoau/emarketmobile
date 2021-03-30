 <?php 
//session_start();




 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
    require_once 'setting_server.php';


    $username = $_POST['username'];
    $password = $_POST['password'];
  

    if(empty($username)){
        $ray = array(
            "status" => "false",
            "message" => "Username anda kosong");
        echo json_encode($ray);
    }
    else if(empty($password)){
        $ray = array(
            "status" => "false",
            "message" => "Password anda kosong");
        echo json_encode($ray);
    }
    else{

    $user_query = "SELECT * FROM user WHERE username= '$username'";
    $user_sql =mysqli_query($con,$user_query);
    $user_ray = array();
    while ($user_row = mysqli_fetch_array($user_sql)){
        array_push($user_ray, array(
            "status" => "berhasil"));
    }

    if(empty($user_ray)){
        $ray =array(
            "status" => "false",
            "message" => "Username anda tidak terdaftar");
        echo json_encode($ray);
    }

    else{
        $query ="SELECT * FROM user WHERE username = '$username' and password ='$password'";
        $sql = mysqli_query($con, $query);
        $ray = array();
        while ($row =mysqli_fetch_array($sql)){
            $ray = array(
                "status" => "true",
                "message" => "Berhasil login"
                
            );
            echo json_encode($ray);

        }
        if(empty($ray)){
            $ray = array(
                "status" => "false",
                "message" => "Password Anda salah");
            echo json_encode($ray);

        }
        else{
            echo json_encode($ray);
            mysqli_close($con);
        }
    }
}
}
else{
    $ray = array(
      "status" => "false",
      "message" => "Bad Request");
            echo json_encode($ray);

}
      

   
?>