package cn.zhangbin.selfstudy.day06;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        String value = "empno:7369|ename:Smith|job:Clerk|salary:750.00|hiredate:2022-02-08|" +
                "dept.dname:财务部|dept.company.name:MLDM";
        Emp emp = ClassInstancefactory.create(Emp.class,value);
        System.out.println("编号: "+emp.getEmpno()+" - 姓名: "+emp.getEname()+" - 职位: "+emp.getJob()+" - 收入: "+emp.getSalary()+" - 入职日期: "+emp.getHiredate()
        +" - 部门名称: "+emp.getDept().getDname()+" - 所属企业: "+emp.getDept().getCompany().getName());
    }
}
class ClassInstancefactory{
    private ClassInstancefactory(){}

    /**
     * 实例化对象的创建方法,该对象可以根据传入的字符串结构"属性:内容|属性:内容"
     * @param clazz 要进行反射实例化的Class类对象,有Class就可以反射实例化对象
     * @param value 要设置给对象的属性内容
     * @return 一个已经配置号属性内容的JAVA类对象
     */
    public static <T> T create(Class<?> clazz,String value){
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj,value);
            return (T) obj;
        }catch (Exception e){
            e.printStackTrace(); // 如果此时出现了错误,本质上抛出异常也无用
            return null;
        }
    }
}
class StringUtils{
    public static String initcap(String str){
        if (str == null || "".equals(str)){ // 如果字符串为空则直接返回
            return str;
        }
        if (str.length() == 1){
            return str.toUpperCase(); // 如果仅有一位则直接返回大写
        }else { // 否则返回首字母大写
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
    }
}
class BeanUtils{ // 进行Bean处理类
    private BeanUtils(){}

    /**
     * 实现指定对象的属性设置
     * @param obj 要进行反射操作的实例化对象
     * @param value 包含有指定内容的字符串,格式"属性:内容|属性:内容"
     */
    public static void setValue(Object obj,String value){
        String[] results = value.split("\\|"); // 按照|进行拆分
        for (int i = 0; i < results.length; i++) { // 循环设置属性内容
            //attval[0] 保存属性名称 1保存属性值
            String[] attval = results[i].split(":"); // 获取属性名称及内容
            try {
                if (attval[0].contains(".")){
                    String[] temp = attval[0].split("\\.");
                    Object currentObject = obj;
                    //最后一位肯定是指定类中的属性名称,所以不在本次实例化处理的范围之内
                    for (int j = 0; j < temp.length-1; j++) { // 实例化
                        //调用乡音高德getter方法,如果getter方法反悔了null表示该对象未实例化
                        Method getMethod = currentObject.getClass().getDeclaredMethod("get"+StringUtils.initcap(temp[j]));
                        Object tempObject = getMethod.invoke(currentObject);
                        if (tempObject == null){ // 表示该对象没有被实例化
                            Field field = currentObject.getClass().getDeclaredField(temp[j]);
                            Method method = currentObject.getClass().getDeclaredMethod("set"+StringUtils.initcap(temp[j]),field.getType());
                            Object newObject = field.getType().getDeclaredConstructor().newInstance(); // 实例化一个对象
                            method.invoke(currentObject,newObject); // 调用newObject方法
                            currentObject = newObject;
                        }else {
                            currentObject = tempObject;
                        }
                    }
                    Field field = currentObject.getClass().getDeclaredField(temp[temp.length-1]); // 获取成员
                    Method setMethod = currentObject.getClass().getDeclaredMethod("set"+StringUtils.initcap(temp[temp.length-1]),field.getType());
                    Object val = BeanUtils.convertAttributeValue(field.getType().getName(),attval[1]);
                    setMethod.invoke(currentObject,val); // 调用settter方法
                }else {
                    Field field = obj.getClass().getDeclaredField(attval[0]); // 获取成员
                    Method setMethod = obj.getClass().getDeclaredMethod("set"+StringUtils.initcap(attval[0]),field.getType());
                    Object val = BeanUtils.convertAttributeValue(field.getType().getName(),attval[1]);
                    setMethod.invoke(obj,val); // 调用settter方法
                }
            }catch (Exception e){

            }
        }
    }

    /**
     * 实现属性类型转换处理
     * @param type 属性类型,通过Field获得
     * @param value 属性的内容,传入的都是字符串,要将其变为指定的类型
     * @return 转换后的数据
     */
    private static Object convertAttributeValue(String type,String value){
        if ("long".equals(type) || "java.lang.Long".equals(type)){
            return Long.parseLong(value);
        }else if ("int".equals(type) || "java.lang.int".equals(type)){
            return Integer.parseInt(value);
        }else if ("double".equals(type) || "java.lang.Double".equals(type)){
            return Double.parseDouble(value);
        }else if ("java.util.Date".equals(type)){
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")){ // 日期类型
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }else if(value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else {
                return new Date(); // 当前日期
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        }else {
            return value;
        }
    }
}
class Company{
    private String name;
    private Date createdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
class Dept{
    private String dname;
    private String loc;
    private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
class Emp{
    private long empno;
    private String ename;
    private String job;
    private double salary;
    private Date hiredate;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}
