import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Cleartax {
    public static void main(String[] args) {


        JSONParser parser = new JSONParser();


        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("d:\\file.json"));
            System.out.println(prettyPrint(obj,2));
            Object a = obj.get("lhs");
            Object b = obj.get("rhs");
            getPath((JSONObject) a);
            JSONObject value = transfer(a, b);
            String s=prettyPrint(value,2);
            System.out.println(s);
            System.out.println(evaluate((JSONObject)value.get("rhs")));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static boolean getPath(Object a) {
        if(a instanceof Long)return false;
        if(a instanceof String) return true;

        boolean value = getPath(((JSONObject) a).get("lhs")) ;
        boolean val2=getPath(((JSONObject) a).get("rhs"));
        ((JSONObject) a).put("contains",value|| val2);

        return value||val2;

    }

    private static long evaluate(JSONObject obj1) {
        Object left = obj1.get("lhs");
        long rightVal;
        long leftVal=rightVal=0;
        Object right = obj1.get("rhs");
        if(left instanceof Long)leftVal= (long) left;
        else leftVal=evaluate((JSONObject) left);
        if(right instanceof Long)rightVal= (long) right;
        else rightVal=evaluate((JSONObject) right);
        String oper = (String) obj1.get("op");
        return applyOp(convertOperand(oper),leftVal,rightVal);

    }

    private static JSONObject transfer(Object a, Object b) {
        JSONObject obj1 = (JSONObject) a;
        Object left = obj1.get("lhs");
        Object right = obj1.get("rhs");
        String oper = (String) obj1.get("op");
        JSONObject robj = new JSONObject();
        if(left!=null && left instanceof Long || (!(left instanceof String) && !((boolean)((JSONObject)left).get("contains"))==true))
        { //
            transform(b, left, oper, robj);


            if(right instanceof String){return getFinal(right,robj);}
            else{return transfer(right,robj);}
        }
        else if(right!=null && right instanceof Long || (!(right instanceof String) && !((boolean)((JSONObject)right).get("contains"))==true)){
            transformright(b, right, oper, robj);
            if(left instanceof String){return getFinal(left,robj);}
            else{return transfer(left,robj);}
        }

        return obj1;
    }



    private static JSONObject getFinal(Object left, Object right) {
        JSONObject robj = new JSONObject();
        robj.put("lhs",left);
        robj.put("rhs",right);
        robj.put("op","equal");
        return robj;
    }

    private static JSONObject transformright(Object b, Object left, String oper, JSONObject robj) {
        if(oper.equals("add")){

            robj.put("lhs",b);
            robj.put("rhs",left);
            robj.put("op","subtract");
        }
        if(oper.equals("subtract")){
            robj.put("lhs",b);
            robj.put("rhs",left);
            robj.put("op","add");
        }
        if(oper.equals("multiply")){
            robj.put("lhs",b);
            robj.put("rhs",left);
            robj.put("op","divide");
        }
        if(oper.equals("divide")){
            robj.put("lhs",b);
            robj.put("rhs",left);
            robj.put("op","multiply");
        }
        return robj;
    }

    private static void transform(Object b, Object left, String oper, JSONObject robj) {
        if(oper.equals("add")){

            robj.put("lhs",b);
            robj.put("rhs",left);
            robj.put("op","subtract");
        }
        if(oper.equals("subtract")){
            robj.put("rhs",b);
            robj.put("lhs",left);
            robj.put("op","subtract");
        }
        if(oper.equals("multiply")){
            robj.put("lhs",b);
            robj.put("rhs",left);
            robj.put("op","divide");
        }
        if(oper.equals("divide")){
            robj.put("rhs",b);
            robj.put("lhs",left);
            robj.put("op","divide");
        }
    }

    private static String prettyPrint(Object obj, int parent) {
        StringBuilder builder = new StringBuilder();
        if (obj instanceof Long)
            return (Long) obj + "";
        if (obj instanceof String) return (String) obj;
        else {
            JSONObject obj1 = (JSONObject) obj;
            Object left = obj1.get("lhs");
            Object right = obj1.get("rhs");
            if (parent < 1) builder.append('(');
            builder.append(prettyPrint(left,  parent - 1));
            char op = convertOperand((String) obj1.get("op"));
            builder.append(op);
            builder.append(prettyPrint(right, parent - 1));
            if (parent < 1) builder.append(')');

            return builder.toString();
        }
    }

    private static char convertOperand(String op) {
        switch (op) {
            case "add":
                return '+';
            case "subtract":
                return '-';
            case "multiply":
                return '*';
            case "divide":
                return '/';
            case "equal":
                return '=';
            default:
                return '$';
        }

    }




    public static long applyOp(char op, long a, long b)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}
