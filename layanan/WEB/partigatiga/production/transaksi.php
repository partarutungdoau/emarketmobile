<?php
	include 'connect.php';
?>

<h2>Transaksi</h2>
<div class="x_content">
    <table class="table table-striped projects">
        <thead>
            <tr>
                <th style="width: 1%">#</th>
                <th style="width: 20%">Nama Lengkap</th>
                <th>Jenis Kelamin</th>
                <th>No. Telepon</th>
                <th style="width: 20%">Aksi</th>
            </tr>
        </thead>
        <tbody>
        <?php $nomor=1; ?>
        <?php $get=$connect->query("SELECT * FROM transaksi "); ?>
        <?php while($pecah = $get->fetch_assoc()){ ?>
            <tr>
                <td><?php echo $nomor; ?></td>
                <td>
                    <?php echo $pecah['nama']; ?>
                </td>
                <td>...
                </td>
                <td class="project_progress">
                    ...
                </td>
                <td>
                    <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i> View </a>
                    <a href="#" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                    <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                </td>
            </tr>      
            <?php $nomor++;?>
            <?php } ?>
        </tbody>
    </table>
    <a href="#" class="btn btn-success btn-xs"><i class="fa fa-folder"></i>Tambah Transaksi</a>
    <!-- end project list -->

</div>