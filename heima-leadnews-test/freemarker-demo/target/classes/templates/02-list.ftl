<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World!</title>
</head>
<body>

<#-- list 数据的展示 -->
<b>展示list中的stu数据:</b>
<br>
<br>
<table border="1">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>钱包</th>
    </tr>

    <#if stus??>
        <#list stus as stu>
<#--在freemarker中=与==功能相同-->
            <#if stu.name=='小红'>
                <tr style="color:#ff0000">
                    <td>${stu_index + 1}</td>
                    <td>${stu.name}</td>
                    <td>${stu.age}</td>
                    <td>${stu.money}</td>
                </tr>
            <#else >
                <tr>
                    <td>${stu_index + 1}</td>
                    <td>${stu.name}</td>
                    <td>${stu.age}</td>
                    <td>${stu.money}</td>
                </tr>
            </#if>
        </#list>
    </#if>

    stus集合的大小：${stus?size}

</table>
<hr>

<#-- Map 数据的展示 -->
<b>map数据的展示：</b>
<br/>
<br/>
<a href="###">方式一：通过map['keyname'].property</a><br/>
输出stu1的学生信息：<br/>
姓名：${stuMap['stu1'].name}<br/>
年龄：${stuMap['stu1'].age}<br/>
<br/>
<a href="###">方式二：通过map.keyname.property</a><br/>
输出stu2的学生信息：<br/>
姓名：${stuMap.stu2.name}<br/>
年龄：${stuMap.stu2.age}<br/>

<br/>
<a href="###">遍历map中两个学生信息：</a><br/>
<table>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>钱包</th>
    </tr>
    <#list stuMap?keys as key>
        <tr>
            <td>${key_index + 1}</td>
            <td>${stuMap[key].name}</td>
            <td>${stuMap[key].age}</td>
            <td>${stuMap[key].money}</td>
            <td>${key}</td>
        </tr>
    </#list>
</table>
<hr>


-----------------------------------------------------<br>
当前的日期为：${today?datetime}<br>
当前的日期为：${today?string("yyyy年MM月")}<br>
${point}<br>
${point?c}<br>
assign作用是定义一个变量<br>
<#assign text="{'bank':'123','cnm':'1213'}"/>
<#assign data=text?eval/>
银行:${data.bank} 草泥马:${data.cnm}
</body>
</html>