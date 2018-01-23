package lolipop.core.annotation;

import java.lang.annotation.*;

/**
 * 名称：MapperInject<br>
 *
 * 描述：自定义注解（注入Mapper对象）<br>
 https://www.cnblogs.com/gmq-sh/p/4798194.html
@Target,
@Retention,
@Documented,
@Inherited  元注解的作用就是负责注解其他注解 就是内容可以被代码理解的注释，一般是一个类。
RetentionPolicy.SOURCE  : 注解只保留在源文件中
RetentionPolicy.CLASS  : 注解保留在class文件中，在加载到JVM虚拟机时丢弃
RetentionPolicy.RUNTIME  : 注解保留在程序运行期间，此时可以通过反射获得定义在某个类上的所有注解。

也叫元注解，是放在被定义的一个注解类的前面 定义自己的注解，是对注解一种限制。只有两个： @Retention 和 @Target  （我只查到这两个）.
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MapperInject {
	
	/**
	 * 对象类型（默认 Object 则认为是 DelegateMapper 类型）<br>
	 *
	 * @return Class<?> 对象类型（反射机制）
	 */
	Class<?> value() default Object.class;
}