def call(String step=''){
  sh 'packer validate /var/lib/jenkins/workspace/sas2/resources/pack.json'
  sh 'packer build -debug -machine-readable -var aws_access_key="${AWS_ACCESS_KEY_ID}"  -var aws_secret_key="${AWS_SECRET_ACCESS_KEY}"   /var/lib/jenkins/workspace/sas2/resources/pack.json > ~/workspace/sas2/terraform/output.txt '
  sh 'AMI_ID=$(awk \'END {print $NF}\' ~/workspace/sas2/terraform/output.txt)'
  sh 'pwd'
  sh 'temp=`variable \"AMI_ID\" { default = \"`'
  sh 'temp2=`\" }`'
   sh 'pwd'
  sh 'c="$temp$AMI_ID$temp2"'
  sh 'pwd'
  echo "$c "  //> ~/workspace/sas2/terraform/var.tf"
  echo "step :${step}"
  }
