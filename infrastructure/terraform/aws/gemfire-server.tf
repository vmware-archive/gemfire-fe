resource "aws_instance" "gemfire_server" {

  ami                         = "${var.ami_id}"
  instance_type               = "${var.server_instance_type}"
  key_name                    = "${var.aws_key_name}"
  subnet_id                   = "${element(var.subnet_ids, count.index)}"
  private_ip                  = "${var.server_private_ips[count.index]}"
  associate_public_ip_address = true
  vpc_security_group_ids      = "${var.security_group_ids}"
  iam_instance_profile        = "${var.instance_profile_name}"
  availability_zone           = "${element(var.availability_zones, count.index)}"
  count                       = "${var.server_count}"

  tags = {
    Name = "gemfire-server-${count.index}"
    Project = "gemfire-fe"
  }

  ebs_block_device {
    device_name = "/dev/xvdf"
    volume_type = "gp2"
    volume_size = "10"
    delete_on_termination = true
  }

}

output "server_public_ips" {
  value = "${aws_instance.gemfire_server.*.public_ip}"
}