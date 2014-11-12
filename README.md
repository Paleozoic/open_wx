#open_wx
PS1：项目主要抄袭BLOG：http://blog.csdn.net/lyq8479/article/category/1366622/2   
PS2：不保证项目100%可以使用，因为没有在外网环境用真实的key进行过测试。   
#注意事项
（1）注意cons包下的ConstStr.java里面的AppId，AppSecret以及TOKEN，将他们替换为真实的key；   
（2）验证开发者需要将项目部署到外网，在微信公众号里填写Token和验证的url。   
 一般形式为：   
    URL：http://xxx.xxx.xxx/open_wx/wx/   
    Token：weixin(这个可以自定义)   
（3）验证成功后，对于与用户的交互（比如菜单和对话）在ButtonEvent.java里面实现；   
（4）公众号菜单的实现注意services包里面的代码，菜单创建需要在本地Run as junit位于test包下的java/menu/testMenu.java才可以在微信服务器生成菜单。   

#部署方法
（1）将代码导入MyEclipse，直接将代码部署到本地Tomcat；  
（2）在Tomcat的webapp文件夹中，将部署的该项目复制到外网的服务器上。   
PS：可能还有一些更加简单的部署方式，我没有做深入研究。
