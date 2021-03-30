<?php
    include "connect.php";
?>
<?php
//mendapatkan id dari url
$customer_id = $_GET["id"];

$get = $connect->query("SELECT * FROM user WHERE id_user='$customer_id'");
$detail_customer =$get->fetch_assoc();

// echo "<pre>";
// print_r($detail_customer);
// echo "<pre>";
?> 

<div class="x_content">
    <h2><strong><?php echo $detail_customer['nama']; ?></strong></h2>
    <form class="form-horizontal form-label-left" novalidate>
        <table class="table table-striped projects">
            <tr>
                <td style="width: 20%"><strong>Nama Lengkap</strong></td>
                <td style="width: 2%"><strong>:</strong></td>
                <td><strong><?php echo $detail_customer['nama']; ?></strong></td>
            </tr>
            <tr>
                <td style="width: 20%"><strong>Alamat</strong></td>
                <td style="width: 2%"><strong>:</strong></td>
                <td><strong><?php echo $detail_customer['alamat']; ?></strong></td>
            </tr>
            <tr>
                <td style="width: 20%"><strong>Email</strong></td>
                <td style="width: 2%"><strong>:</strong></td>
                <td><strong><?php echo $detail_customer['email']; ?></strong></td>
            </tr>
            <tr>
                <td style="width: 20%"><strong>No Telepon</strong></td>
                <td style="width: 2%"><strong>:</strong></td>
                <td><strong><?php echo $detail_customer['no_telepon']; ?></strong></td>
            </tr>
        

        </table>
    </form>

</div>
