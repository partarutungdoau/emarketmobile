<h2>Pedagang</h2>
<div class="x_content">
    <table class="table table-striped projects">
        <thead>
            <tr>
                <th style="width: 1%">#</th>
                <th style="width: 20%">Nama Lengkap</th>
                <th>Alamat</th>
                <th>Email</th>
                 <th>No telepon</th>
                <th style="width: 20%">Aksi</th>
            </tr>
        </thead>
        <tbody>
        <?php $nomor=1; ?>
        <?php $get=$connect->query("SELECT * FROM user where role ='Pedagang' "); ?>
        <?php while($pecah = $get->fetch_assoc()){ ?>
            <tr>
                <td><?php echo $nomor; ?></td>
                <td>
                    <?php echo $pecah['nama']; ?>
                </td>
                <td>
                    <?php echo $pecah['alamat']; ?>
                </td>
                <td>
                    <?php echo $pecah['email']; ?>
                </td>
                <td>
                    <?php echo $pecah['no_telepon']; ?>
                </td>
                <td>
                    <a href="index.php?halaman=detail_pedagang&id=<?php echo $pecah['id_user']; ?>" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                    <a href="#" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                    <a href="index.php?halaman=hapus_pedagang&id=<?php echo $pecah['id_user']; ?>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                </td>
            </tr>      
            <?php $nomor++;?>
            <?php } ?>
        </tbody>
    </table>
    <a href="index.php?halaman=tambah_pedagang" class="btn btn-success btn-xs"><i class="fa fa-folder"></i>Tambah Pedagang</a>
    <!-- end project list -->

</div>