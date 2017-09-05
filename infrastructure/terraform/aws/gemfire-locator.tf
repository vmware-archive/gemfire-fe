resource "aws_instance" "gemfire-locator" {

  ami                         = "${var.ami_id}"
  instance_type               = "t2.large"
  key_name                    = "${var.aws_key_name}"
  subnet_id                   = "${var.subnet_id}"
  private_ip                  = "${var.gemfire_locator_private_ips[count.index]}"
  associate_public_ip_address = true
  vpc_security_group_ids      = "${var.security_group_ids}"
  iam_instance_profile        = "${var.instance_profile_name}"

  tags = {
    Name = "iot_demo_admin"
    Project = "iot_demo"
  }

  connection {
    type        = "ssh"
    user        = "${var.ssh_user}"
    private_key = "${file(var.ssh_private_key)}"
  }

  provisioner "file" {
    source      = "gemfire-locator-init.sh"
    destination = "/tmp/gemfire-locator-init.sh"
  }

  provisioner "remote-exec" {
    inline = [
      "sudo chmod +x /tmp/gemfire-locator-init.sh",
      "sudo /tmp/gemfire-locator-init.sh ",
    ]
  }

  provisioner "remote-exec" {
    inline = [
      "true",
    ]
  }
}
