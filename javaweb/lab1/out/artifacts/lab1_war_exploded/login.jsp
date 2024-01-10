<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<style>
  h1 {
    color: red;
    text-shadow: 2px 2px yellow;
  }
  div {
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
<script type="text/javascript">
  function yanz1()
  {

    if (form.name.value.length<3 || form.name.value.length>5)
    {
      document.getElementById("namel").style.color='red';
      return false;
    }
    else
    {
      document.getElementById("namel").style.color='green';
      return true;
    }
  }
  function yanz2()
  {
    if(form.pwd.value.length<8 || form.pwd.value.length>12)
    {
      document.getElementById("pwd1").style.color='red';
      return false;
    }
    else
    {
      document.getElementById("pwd1").style.color='green';
      return true;
    }
  }
  function yanz3()
  {
    if(form.pwd.value!=form.pwd2.value)
    {
      document.getElementById("pwd2").style.color='red';
      return false;
    }
    else
    {
      document.getElementById("pwd2").style.color='green';
      return true;
    }
  }
  function yanz4()
  {
    var pattern = /^([0-9a-zA-Z_\.\-\])+\@([0-9a-zA-Z_\.\-\])+\.([a-zA-Z]+)$/;
    if(!pattern.test(form.email.value))
    {
      document.getElementById("email").style.color='red';
      return false;
    }
    else
    {
      document.getElementById("email").style.color='green';
      return true;
    }
  }
  function yanz5()
  {
    if(form.tel.value.length!=11)
    {
      document.getElementById("tel").style.color='red';
      return false;
    }
    else
    {
      document.getElementById("tel").style.color='green';
      return true;
    }
  }
  function yanz6()
  {
    if(form.truename.value.length<2 || form.truename.value.length>5)
    {
      document.getElementById("tname").style.color='red';
      return false;
    }
    else
    {
      document.getElementById("tname").style.color='green';
      return true;
    }
  }
  function yanz7()
  {
    if(form.shengfen.selectedIndex>0)
    {
      document.getElementById("shengf").style.color='green';
      return false;
    }
    else{
      document.getElementById("shengf").style.color='red';
      return true;
    }
  }
  function Check()
  {
    if(yanz1()&&yanz2()&&yanz3()&&yanz4()&&yanz5()&&yanz6()&&yanz7())
    {
      return true;
    }
    else{
      return false;
    }
  }
</script>
<style>

</style>
<body>

<form name="form" onsubmit="return Check();">
  <div><h1>用户注册</h1></div>

  <table align="center">
    <tr>
      <td align="right"> 用户名:</td>
      <td><input type="text" name="name" onblur="yanz1()">

        <label id="namel">用户名由3-5个字符组成</label></td>
    </tr>
    <tr>
      <td align="right"> 密码:
      <td><input type="password" name="pwd" onblur="yanz2()">

      <label id="pwd1">输入8-12位密码</label>
      </td>
    </tr>
    <tr>
      <td align="right"> 确认密码:
      <td><input type="password" name="pwd2" onblur="yanz3()">
      <label id="pwd2">两次密码不一致</label>
      </td>
    </tr>
    <tr>
      <td align="right"> Email:
      <td><input type="text" name="email" onblur="yanz4()">
      <label id="email">格式示例：xxxxxxxx@163.com</label>>
      </td>
    </tr>
    <tr>
      <td align="right"> 手机号码:
      <td><input type="text" name="tel" onblur="yanz5()">
      <label id="tel">格式示例：13803780000</label>>
      </td>
    </tr>
    <tr>
      <td align="right"> 真实姓名:
      <td><input type="text" name="truename" onblur="yanz6()">
      <label id="tname">由2-5个中文组成</label>>
      </td>
    </tr>

    <tr>
      <td align="right">省份：
      </td>
      <td>
        <select name="shengfen" onblur="yanz7()">
          <option value="none" selected disabled hidden>--请选择--</option>
          <option value="1">河南</option>
          　　　　<option value="2">河北</option>
          　　　　<option value="3">上海</option>
          　　　　<option value="4">北京</option>
          　　　　<option value="5">南京</option>
          　　　　<option value="6">西安</option>
          　　　　<option value="7">浙江</option>
        </select><label id="shengf">请选择省份</label>
      </td>
    </tr>
    <tr>
      <td align="right">
        技术方向：</td>
      <td><input name="jishu" type="radio" value="Java">Java<input type="radio" value="net">.Net<input type="radio" value="php">PHP<input type="radio" value="ios">IOS<input type="radio" value="web">网页<input type="radio" value="Android">Android</td></tr>

  </table>
  <div><button style="margin:3px 6px;">注册</button><button style="margin:3px 6px;">重置</button></div>
</form>

</body>
</html>