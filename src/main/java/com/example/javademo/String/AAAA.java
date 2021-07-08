package com.example.javademo.String;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class AAAA {

    public static void main(String[] args) throws Exception {
        String st = "'交易退款'== '交易退款'  ? 'R' : ('在线支付'== '交易退款'  ? 'S' : '')";
        //"交易退款".equals( COLUMN11 ) ? COLUMN7 : ("在线支付".equals( COLUMN11 ) ?COLUMN8 : "")
        //'交易退款'==column11  ? column7 : ('在线支付'==column11  ?column8 : 0.00)
//'交易退款'== COLUMN11  ? 'R' : ('在线支付'== COLUMN11  ? 'S' : '')
        String ex = "'交易退款'== column11  ? (new java.math.BigDecimal( column8 ).subtract( new java.math.BigDecimal( column7 ) )) : ('在线支付'== column11  ? (new java.math.BigDecimal(column7 ).subtract( new java.math.BigDecimal( column8 ) )) : 0.00)";
        String str = "'adf'.substring(0,1)=='I'?'I':'D'";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(st);
        System.out.println(exp.getValue());
    }
}
