/* Parser.java */
/* Generated By:JavaCC: Do not edit this line. Parser.java */
package com.github.braisdom.jsql;

import java.util.*;
import com.github.braisdom.jsql.ast.*;

public final class Parser implements ParserConstants {

    public static String unquote(String value, String quote) {
        if (value.startsWith(quote) && (value.endsWith(quote))) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

  final public JSqlNode JSqlNode() throws ParseException {final JSqlNode jsqlNode = new JSqlNode();
    ImportNode importNode;
    DatasetNode datasetNode;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IMPORT:
      case DATASET:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IMPORT:{
        importNode = ImportNode();
jsqlNode.addImportNode(importNode);
        break;
        }
      case DATASET:{
        datasetNode = DatasetNode();
jsqlNode.addDatasetNode(datasetNode);
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return jsqlNode;}
    throw new Error("Missing return statement in function");
}

  final public ImportNode ImportNode() throws ParseException {ImportNode importNode;
    String importDeclaration;
    jj_consume_token(IMPORT);
    importDeclaration = Name();
importNode = new ImportNode(importDeclaration);
    jj_consume_token(SEMICOLON);
{if ("" != null) return importNode;}
    throw new Error("Missing return statement in function");
}

  final public DatasetNode DatasetNode() throws ParseException {final DatasetNode datasetNode = new DatasetNode();
    FormalParameterNode parameter;
    Projectional projectional;
    jj_consume_token(DATASET);
    jj_consume_token(IDENTIFIER);
datasetNode.setName(getToken(0).image);
    jj_consume_token(LPAREN);
    parameter = FormalParameterNode();
datasetNode.addFormalParameter(parameter);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      parameter = FormalParameterNode();
datasetNode.addFormalParameter(parameter);
    }
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    jj_consume_token(PROJECTION);
    jj_consume_token(LBRACE);
    Projectional(datasetNode);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      Projectional(datasetNode);
    }
    jj_consume_token(RBRACE);
    jj_consume_token(RBRACE);
{if ("" != null) return datasetNode;}
    throw new Error("Missing return statement in function");
}

  final public FormalParameterNode FormalParameterNode() throws ParseException {String type;
    String name;
    jj_consume_token(IDENTIFIER);
type = getToken(0).image;
    jj_consume_token(IDENTIFIER);
name = getToken(0).image;
{if ("" != null) return new FormalParameterNode(type, name);}
    throw new Error("Missing return statement in function");
}

  final public void Projectional(DatasetNode datasetNode) throws ParseException {Projectional projectional = null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case COLON:
    case STRINGVAL:
    case DECIMAL_LITERAL:
    case FLOATING_LITERAL:
    case BOOLEAN_LITERAL:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COLON:{
        projectional = SymbolNode();
        break;
        }
      case STRINGVAL:
      case DECIMAL_LITERAL:
      case FLOATING_LITERAL:
      case BOOLEAN_LITERAL:{
        projectional = ScalarNode();
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
datasetNode.addProjectional(projectional);
}

  final public SqlFunctionCallNode SqlFunctionCallNode() throws ParseException {SqlFunctionCallNode sqlFunctionCallNode = new SqlFunctionCallNode();
    Token expr;
    jj_consume_token(IDENTIFIER);
sqlFunctionCallNode.setName(getToken(0).image);
    jj_consume_token(LPAREN);
    expr = jj_consume_token(IDENTIFIER);
sqlFunctionCallNode.setExpression(expr.image);
    jj_consume_token(RPAREN);
{if ("" != null) return sqlFunctionCallNode;}
    throw new Error("Missing return statement in function");
}

  final public ScalarNode ScalarNode() throws ParseException {Object value = null;
    Token token;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case STRINGVAL:{
      token = jj_consume_token(STRINGVAL);
value = token.image;
      break;
      }
    case DECIMAL_LITERAL:{
      token = jj_consume_token(DECIMAL_LITERAL);
value = Integer.parseInteger(token.image);
      break;
      }
    case FLOATING_LITERAL:{
      token = jj_consume_token(FLOATING_LITERAL);
value = Float.parseFloat(token.image);
      break;
      }
    case BOOLEAN_LITERAL:{
      token = jj_consume_token(BOOLEAN_LITERAL);
value = Boolean.parseBoolean(token.image);
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return new ScalarNode(value);}
    throw new Error("Missing return statement in function");
}

  final public SymbolNode SymbolNode() throws ParseException {Token token;
    jj_consume_token(COLON);
    token = jj_consume_token(IDENTIFIER);
{if ("" != null) return new SymbolNode(token.image);}
    throw new Error("Missing return statement in function");
}

  final public String Name() throws ParseException {List<String> names = new ArrayList();
    jj_consume_token(IDENTIFIER);
names.add(getToken(0).image);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DOT:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      jj_consume_token(DOT);
      jj_consume_token(IDENTIFIER);
names.add(getToken(0).image);
    }
{if ("" != null) return String.join(".", names.toArray(new String[0]));}
    throw new Error("Missing return statement in function");
}

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x600,0x600,0x2,0x2,0xe0048,0xe0048,0xe0040,0x4,};
	}

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[54];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 8; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 54; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
