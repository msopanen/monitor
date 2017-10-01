# Your application 'monitor' is now available.

  URL:        http://monitor-fimps.rhcloud.com/
  SSH to:     574741c42d52713769000047@monitor-fimps.rhcloud.com
  Git remote: ssh://574741c42d52713769000047@monitor-fimps.rhcloud.com/~/git/monitor.git/
  Cloned to:  /home/ubuntu/monitor
  
  Deploy: scp ./web/target/ROOT.war 574741c42d52713769000047@monitor-fimps.rhcloud.com:app-root/runtime/dependencies/jbossews/webapps/.

  http://monitor-fimps.rhcloud.com/rest/temperature/register?id=a&title=test&label=a&min=0&max=50
  http://monitor-fimps.rhcloud.com/rest/temperature/set?id=a&value=25
  http://monitor-fimps.rhcloud.com/rest/temperature/get?id=a
  http://monitor-fimps.rhcloud.com/rest/temperature/list
  http://monitor-fimps.rhcloud.com/rest/temperature/register?id=3b-000000182e5a&title=Poltin&label=C&min=0&max=150

  mikko.p.sopanen@gmail.com/inpoT3nssi

# Register sensors
  http://monitor-fimps.rhcloud.com/rest/temperature/register?id=28-00142171e4ff&title=Jyvat&label=C&min=0&max=80
  http://monitor-fimps.rhcloud.com/rest/temperature/register?id=28-00044e90cbff&title=Ulko&label=C&min=-50&max=50
  http://monitor-fimps.rhcloud.com/rest/temperature/register?id=3b-000000182e5a&title=Poltin&label=C&min=0&max=150
  http://monitor-fimps.rhcloud.com/rest/temperature/register?id=28-0000052fcdaa&title=Poisto&label=C&min=0&max=80