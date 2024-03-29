package emuladorprocesadorz80;
/* The following code was generated by JFlex 1.7.0 */

/* Sección de declaraciones de JFlex */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>C:/Users/Andrey/Desktop/Z80/src/Assets/AnalizadorLexico.flex</tt>
 */
import java_cup.runtime.*;
import java.io.Reader;
      
public class AnalizadorLexico {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\7\1\3\1\21\1\21\1\4\22\0\1\6\1\40\1\75"+
    "\1\20\1\0\1\45\1\36\1\74\1\60\1\61\1\23\1\43\1\66"+
    "\1\44\1\5\1\22\6\2\4\2\1\67\1\57\1\42\1\37\1\41"+
    "\1\0\1\0\1\24\3\1\1\73\1\1\1\26\1\1\1\31\2\1"+
    "\1\25\1\33\1\1\1\27\2\1\1\30\1\1\1\32\6\1\1\64"+
    "\1\76\1\65\1\46\1\70\1\0\1\51\1\54\1\10\1\16\1\14"+
    "\1\47\1\1\1\72\1\52\2\1\1\53\1\12\1\13\1\11\1\71"+
    "\1\1\1\50\1\34\1\15\1\17\1\56\3\1\1\55\1\62\1\35"+
    "\1\63\7\0\1\21\u1fa2\0\1\21\1\21\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\4\1\5\1\6\5\1"+
    "\1\7\1\10\1\11\2\1\2\0\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\4\1\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\2\1"+
    "\5\0\6\1\1\0\2\1\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\7\1\1\0\1\43\3\0"+
    "\7\1\1\44\1\0\2\1\1\0\10\1\1\45\1\46"+
    "\1\0\1\1\1\47\2\1\1\50\4\1\1\7\2\1"+
    "\1\0\6\1\1\51\1\1\2\0\11\1\1\52\1\53"+
    "\5\1\1\54\2\0\1\55\1\56\2\1\1\57\4\1"+
    "\1\60\2\1\1\61\1\1\1\45\2\0\2\1\1\62"+
    "\1\63\5\1\3\0\1\64\1\65\2\1\1\66\1\67"+
    "\1\1\1\0\1\70\1\1\1\71\1\1\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[184];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\77\0\176\0\275\0\374\0\u013b\0\u013b\0\u013b"+
    "\0\u017a\0\u01b9\0\u01f8\0\u0237\0\u0276\0\u02b5\0\u02f4\0\u013b"+
    "\0\u0333\0\u0372\0\u03b1\0\u03f0\0\u042f\0\u046e\0\u04ad\0\u04ec"+
    "\0\u052b\0\u013b\0\u013b\0\u013b\0\u056a\0\u05a9\0\u05e8\0\u0627"+
    "\0\u013b\0\u013b\0\u013b\0\u013b\0\u013b\0\u013b\0\u013b\0\u013b"+
    "\0\u013b\0\u0666\0\u06a5\0\u06e4\0\u0723\0\u0762\0\275\0\u02f4"+
    "\0\u07a1\0\u07e0\0\u081f\0\u085e\0\u089d\0\u08dc\0\u091b\0\u095a"+
    "\0\u0999\0\u09d8\0\u013b\0\u013b\0\u013b\0\u013b\0\u013b\0\u013b"+
    "\0\u013b\0\u0a17\0\u0a56\0\u0a95\0\u0ad4\0\u0b13\0\u0b52\0\u0b91"+
    "\0\u0bd0\0\u013b\0\u0c0f\0\u0c4e\0\u0c8d\0\u0ccc\0\u0d0b\0\u0d4a"+
    "\0\u0d89\0\u0dc8\0\u0e07\0\u0e46\0\u0e85\0\u0ec4\0\u0f03\0\u0f42"+
    "\0\u0f81\0\u0fc0\0\u0fff\0\u103e\0\u107d\0\u10bc\0\u10fb\0\u113a"+
    "\0\u1179\0\u11b8\0\u013b\0\u11f7\0\u1236\0\77\0\u1275\0\u12b4"+
    "\0\77\0\u12f3\0\u1332\0\u1371\0\u13b0\0\u091b\0\u13ef\0\u142e"+
    "\0\u146d\0\u14ac\0\u14eb\0\u152a\0\u1569\0\u15a8\0\u15e7\0\77"+
    "\0\u1626\0\u1665\0\u16a4\0\u16e3\0\u1722\0\u1761\0\u17a0\0\u17df"+
    "\0\u181e\0\u185d\0\u189c\0\u18db\0\u013b\0\77\0\u191a\0\u1959"+
    "\0\u1998\0\u19d7\0\u1a16\0\77\0\u1a55\0\u1a94\0\77\0\77"+
    "\0\u1ad3\0\u1b12\0\77\0\u1b51\0\u1b90\0\u1bcf\0\u1c0e\0\77"+
    "\0\u1c4d\0\u1c8c\0\77\0\u1ccb\0\u1d0a\0\u1d49\0\u1d88\0\u1dc7"+
    "\0\u1e06\0\77\0\77\0\u1e45\0\u1e84\0\u1ec3\0\u1f02\0\u1f41"+
    "\0\u1f80\0\u1fbf\0\u1ffe\0\77\0\77\0\u203d\0\u207c\0\77"+
    "\0\77\0\u20bb\0\u20fa\0\77\0\u2139\0\77\0\u2178\0\77";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[184];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\0\1\2\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\2\1\12\1\13\1\14\1\2\1\15\1\2"+
    "\1\16\1\0\1\17\1\20\1\21\7\2\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\3\2\1\37\1\2\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\0\1\52\1\53\1\2\1\54\1\55\2\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\10\2\12\0\3\2"+
    "\5\0\1\3\40\0\2\56\27\0\1\54\5\0\2\57"+
    "\13\0\1\16\1\0\1\60\57\0\1\4\1\57\2\0"+
    "\1\10\10\0\1\16\1\0\1\60\154\0\2\2\5\0"+
    "\10\2\4\0\11\2\12\0\2\2\1\61\5\2\12\0"+
    "\3\2\4\0\2\2\5\0\10\2\4\0\11\2\12\0"+
    "\2\2\1\62\1\63\4\2\12\0\3\2\4\0\2\2"+
    "\5\0\7\2\1\64\4\0\11\2\12\0\10\2\12\0"+
    "\3\2\4\0\2\2\5\0\3\2\1\65\4\2\4\0"+
    "\11\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\4\2\1\66\3\2\4\0\11\2\12\0\10\2\12\0"+
    "\3\2\3\0\3\16\2\0\14\16\1\0\55\16\23\0"+
    "\1\67\54\0\2\2\5\0\10\2\4\0\1\2\1\70"+
    "\7\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\4\2\1\71\3\2\4\0\11\2\12\0\3\2\1\72"+
    "\4\2\12\0\3\2\40\0\1\73\77\0\1\74\77\0"+
    "\1\75\76\0\1\76\76\0\1\77\76\0\1\100\103\0"+
    "\1\101\33\0\2\2\5\0\10\2\4\0\11\2\12\0"+
    "\2\2\1\102\5\2\12\0\3\2\4\0\2\2\5\0"+
    "\1\2\1\103\2\2\1\104\3\2\4\0\11\2\12\0"+
    "\10\2\12\0\3\2\4\0\2\2\5\0\1\2\1\105"+
    "\6\2\4\0\11\2\12\0\10\2\12\0\3\2\4\0"+
    "\2\2\5\0\4\2\1\106\3\2\4\0\11\2\12\0"+
    "\10\2\12\0\3\2\4\0\2\2\5\0\10\2\4\0"+
    "\11\2\12\0\2\2\1\107\5\2\12\0\3\2\4\0"+
    "\2\2\5\0\10\2\4\0\11\2\12\0\2\2\1\110"+
    "\5\2\12\0\3\2\3\0\3\111\2\0\14\111\1\0"+
    "\55\111\75\55\1\112\1\113\2\0\1\114\71\0\1\115"+
    "\3\0\2\2\5\0\6\2\1\116\1\2\4\0\10\2"+
    "\1\117\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\5\2\1\120\2\2\4\0\11\2\12\0\10\2\12\0"+
    "\3\2\4\0\2\2\5\0\4\2\1\121\3\2\4\0"+
    "\11\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\10\2\4\0\11\2\12\0\4\2\1\122\3\2\12\0"+
    "\3\2\4\0\2\2\5\0\5\2\1\123\2\2\4\0"+
    "\11\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\1\124\7\2\4\0\11\2\12\0\1\125\7\2\12\0"+
    "\3\2\3\0\21\67\1\0\1\67\1\126\53\67\1\0"+
    "\2\2\5\0\10\2\4\0\2\2\1\127\6\2\12\0"+
    "\10\2\12\0\3\2\4\0\2\2\5\0\10\2\4\0"+
    "\11\2\12\0\4\2\1\130\3\2\12\0\3\2\4\0"+
    "\2\2\5\0\10\2\4\0\11\2\12\0\10\2\11\0"+
    "\1\131\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\4\2\1\132\3\2\12\0\3\2\4\0\2\2"+
    "\5\0\2\2\1\133\5\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\5\2\1\134\2\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\135\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\1\136\7\2\4\0"+
    "\11\2\12\0\1\2\1\137\6\2\12\0\3\2\4\0"+
    "\2\2\5\0\10\2\4\0\11\2\12\0\1\2\1\140"+
    "\6\2\12\0\3\2\4\0\2\2\5\0\1\141\7\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\77\0\1\142"+
    "\2\0\3\55\2\0\14\55\1\0\55\55\2\0\1\114"+
    "\47\0\1\143\21\0\1\115\2\0\3\144\2\0\14\144"+
    "\1\0\55\144\1\0\2\2\5\0\4\2\1\145\3\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\146\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\1\2\1\147\6\2\12\0\3\2\4\0\2\2"+
    "\5\0\3\2\1\150\4\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\1\2\1\151\6\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\152\2\2\1\153\3\2\4\0\11\2"+
    "\12\0\10\2\12\0\3\2\4\0\2\2\5\0\10\2"+
    "\4\0\11\2\12\0\3\2\1\154\4\2\12\0\3\2"+
    "\4\0\2\2\5\0\4\2\1\155\3\2\4\0\11\2"+
    "\12\0\10\2\12\0\3\2\3\0\21\67\1\0\1\156"+
    "\1\126\53\67\1\0\2\2\5\0\10\2\4\0\3\2"+
    "\1\157\5\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\4\2\1\160\3\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\16\0\1\161\64\0\2\2\5\0\10\2"+
    "\4\0\10\2\1\162\12\0\10\2\12\0\3\2\4\0"+
    "\2\2\5\0\10\2\4\0\11\2\12\0\10\2\12\0"+
    "\1\163\2\2\4\0\2\2\5\0\1\2\1\164\6\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\4\2\1\165\3\2"+
    "\12\0\3\2\4\0\2\2\5\0\5\2\1\166\2\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\6\2\1\167\1\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\2\2\1\170\5\2\12\0\3\2\4\0\2\2"+
    "\5\0\4\2\1\171\3\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\5\0\1\142\11\0\1\172\26\0\2\56"+
    "\126\0\1\173\3\0\2\2\5\0\3\2\1\174\4\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\3\2\1\175\4\2"+
    "\12\0\3\2\4\0\2\2\5\0\5\2\1\176\2\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\3\2\1\177\4\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\1\2\1\200\6\2\12\0\3\2\4\0\2\2"+
    "\5\0\2\2\1\201\5\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\1\202\7\2\4\0"+
    "\11\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\10\2\4\0\4\2\1\203\4\2\12\0\10\2\12\0"+
    "\3\2\4\0\2\2\5\0\1\204\7\2\4\0\11\2"+
    "\12\0\10\2\12\0\3\2\14\0\1\205\66\0\2\2"+
    "\5\0\1\2\1\206\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\4\2\1\207\3\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\1\2\1\210\6\2"+
    "\12\0\3\2\4\0\2\2\5\0\4\2\1\211\3\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\212\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\2\2\1\213\5\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\1\2\1\214\6\2"+
    "\12\0\3\2\76\0\1\215\5\0\1\173\11\0\1\216"+
    "\35\0\1\143\25\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\2\2\1\217\5\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\6\2\1\220\1\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\1\2\1\221\6\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\222\7\2\4\0\11\2\12\0\10\2\12\0"+
    "\3\2\4\0\2\2\5\0\1\2\1\223\6\2\4\0"+
    "\11\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\10\2\4\0\11\2\12\0\2\2\1\224\5\2\12\0"+
    "\3\2\4\0\2\2\5\0\5\2\1\225\2\2\4\0"+
    "\11\2\12\0\10\2\12\0\3\2\4\0\2\2\5\0"+
    "\10\2\4\0\5\2\1\226\3\2\12\0\10\2\12\0"+
    "\3\2\4\0\2\2\5\0\1\227\7\2\4\0\11\2"+
    "\12\0\10\2\12\0\3\2\4\0\2\2\5\0\10\2"+
    "\4\0\11\2\12\0\1\2\1\230\6\2\12\0\3\2"+
    "\4\0\2\2\5\0\3\2\1\231\4\2\4\0\11\2"+
    "\12\0\10\2\12\0\3\2\4\0\2\2\5\0\10\2"+
    "\4\0\11\2\12\0\2\2\1\232\5\2\12\0\3\2"+
    "\4\0\2\2\5\0\10\2\4\0\11\2\12\0\1\2"+
    "\1\233\6\2\12\0\3\2\4\0\2\2\5\0\6\2"+
    "\1\234\1\2\4\0\11\2\12\0\10\2\12\0\3\2"+
    "\5\0\1\235\40\0\1\236\126\0\1\237\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\2\2\1\240\5\2"+
    "\12\0\3\2\4\0\2\2\5\0\4\2\1\241\3\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\4\2\1\242\3\2"+
    "\12\0\3\2\4\0\2\2\5\0\1\2\1\243\6\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\6\2\1\244\2\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\3\2\1\245\4\2\12\0\3\2\4\0\2\2"+
    "\5\0\10\2\4\0\11\2\12\0\2\2\1\246\5\2"+
    "\12\0\3\2\4\0\2\2\5\0\3\2\1\247\4\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\4\2\1\250\3\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\5\0\1\235\40\0\2\56\76\0\1\251"+
    "\34\0\1\252\40\0\1\253\34\0\2\2\5\0\10\2"+
    "\4\0\10\2\1\254\12\0\10\2\12\0\3\2\4\0"+
    "\2\2\5\0\10\2\4\0\10\2\1\255\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\7\2"+
    "\1\256\1\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\257\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\1\2\1\260\6\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\261\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\10\2\4\0\11\2"+
    "\12\0\1\2\1\262\6\2\12\0\3\2\5\0\1\235"+
    "\76\0\1\252\47\0\1\143\70\0\1\263\33\0\2\2"+
    "\5\0\10\2\4\0\3\2\1\264\5\2\12\0\10\2"+
    "\12\0\3\2\4\0\2\2\5\0\3\2\1\265\4\2"+
    "\4\0\11\2\12\0\10\2\12\0\3\2\4\0\2\2"+
    "\5\0\1\2\1\266\6\2\4\0\11\2\12\0\10\2"+
    "\12\0\3\2\5\0\1\252\75\0\2\2\5\0\10\2"+
    "\4\0\11\2\12\0\2\2\1\267\5\2\12\0\3\2"+
    "\4\0\2\2\5\0\10\2\4\0\11\2\12\0\1\2"+
    "\1\270\6\2\12\0\3\2\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8631];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\4\1\3\11\7\1\1\11\2\1\2\0\5\1"+
    "\3\11\4\1\11\11\2\1\5\0\6\1\1\0\3\1"+
    "\7\11\7\1\1\0\1\11\3\0\10\1\1\0\2\1"+
    "\1\0\11\1\1\11\1\0\14\1\1\0\10\1\2\0"+
    "\11\1\1\11\7\1\2\0\17\1\2\0\11\1\3\0"+
    "\7\1\1\0\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[184];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 
 public boolean existenTokens(){
 return this._existenTokens;
 }
 


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
   /* Código que se ejecutará en el constructor de la clase */
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 206) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
     
 /* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
 this._existenTokens = false;
 

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public TokenPersonalizado yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "IDENTIFICADOR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 59: break;
          case 2: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ENTERO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 60: break;
          case 3: 
            { TokenPersonalizado t = new TokenPersonalizado("Enter", "NUEVA_LINEA");
 this._existenTokens = true;
 return t;
            } 
            // fall through
          case 61: break;
          case 4: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "TERMINA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 62: break;
          case 5: 
            { //IGNORAR
            } 
            // fall through
          case 63: break;
          case 6: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "NUEVA_LINEA");
 this._existenTokens = true;
 return t;
            } 
            // fall through
          case 64: break;
          case 7: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "COMENTARIO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 65: break;
          case 8: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "DIV");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 66: break;
          case 9: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MULT");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 67: break;
          case 10: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ASIGNAR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 68: break;
          case 11: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "NO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 69: break;
          case 12: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MAYOR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 70: break;
          case 13: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MENOR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 71: break;
          case 14: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "SUMA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 72: break;
          case 15: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MENOS");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 73: break;
          case 16: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MOD");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 74: break;
          case 17: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "POTENCIA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 75: break;
          case 18: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "PCOMA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 76: break;
          case 19: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "PAREN_AP");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 77: break;
          case 20: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "PAREN_CI");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 78: break;
          case 21: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "LLAVEIZ");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 79: break;
          case 22: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "LLAVEDE");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 80: break;
          case 23: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ANGIZ");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 81: break;
          case 24: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ANGDE");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 82: break;
          case 25: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "COMA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 83: break;
          case 26: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "DOSPUNTOS");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 84: break;
          case 27: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "SI");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 85: break;
          case 28: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "O");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 86: break;
          case 29: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "Y");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 87: break;
          case 30: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "IGUAL");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 88: break;
          case 31: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "DIFERENTE");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 89: break;
          case 32: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MAY_IGUAL");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 90: break;
          case 33: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MEN_IGUAL");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 91: break;
          case 34: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "masme");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 92: break;
          case 35: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "CADENA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 93: break;
          case 36: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "DEF");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 94: break;
          case 37: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "REAL");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 95: break;
          case 38: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "COMPLEJO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 96: break;
          case 39: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "CASO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 97: break;
          case 40: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "NULO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 98: break;
          case 41: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "PARA");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 99: break;
          case 42: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "SI_NO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 100: break;
          case 43: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "FALSO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 101: break;
          case 44: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "HACER");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 102: break;
          case 45: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "STRING");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 103: break;
          case 46: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MATRIZ");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 104: break;
          case 47: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "INT");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 105: break;
          case 48: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ROMPER");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 106: break;
          case 49: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "VECTOR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 107: break;
          case 50: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "FLOAT");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 108: break;
          case 51: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "DEFECTO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 109: break;
          case 52: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "MIENTRAS");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 110: break;
          case 53: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ENTONCES");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 111: break;
          case 54: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "RETORNAR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 112: break;
          case 55: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "BOOL");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 113: break;
          case 56: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "ALGORITMO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 114: break;
          case 57: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "VERDADERO");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 115: break;
          case 58: 
            { TokenPersonalizado t = new TokenPersonalizado(yytext(), "SELECCIONAR");
	this._existenTokens = true;
 	return t;
            } 
            // fall through
          case 116: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
