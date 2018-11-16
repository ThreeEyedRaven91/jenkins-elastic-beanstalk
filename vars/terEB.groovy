def deploy(args) {
    sh 'mkdir -p .elasticbeanstalk'
    def file = new File('.elasticbeanstalk/config.yml')
    file << """
branch-defaults:
  develop:
    environment: ${args.env}
environment-defaults:
  ${args.env}:
    branch: null
    repository: null
global:
  application_name: ${args.application}
  default_ec2_keyname: ${args.keyName}
  default_platform: ${args.platform}
  default_region: ${args.region}
  include_git_submodules: true
  instance_profile: null
  platform_name: null
  platform_version: null
  profile: ${args.profile}
  sc: git
  workspace_type: Application"""
    sh "eb deploy ${args.env}"
}