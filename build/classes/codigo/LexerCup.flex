package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

L = [a-zA-Z]
D = [0-9]
AlfaNumerico=({L}+|{L}+{D}+)+
correo={AlfaNumerico}"@"{AlfaNumerico}"."({L}+|{L}+"."{L}+)
LU={AlfaNumerico} | [/.#=?-]
Pagina="www."{AlfaNumerico}"." ({L}+ | ({L}+ "/" {LU}+))
Elementos=({AlfaNumerico} | {AlfaNumerico} " " {AlfaNumerico})+

espacio=[ \t\r\n]+

%{
    private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline, yycolumn, value);
    }

    private Symbol symbol (int type){
        return new Symbol (type, yyline, yycolumn);
    }
%}
%%

{espacio} {/*Ignore*/}

"INI_HTML" {return new Symbol(sym.html_a, yychar, yyline, yytext());}
"FIN_HTML" {return new Symbol(sym.html_c, yychar, yyline, yytext());}
"ENCABEZADO_INI" {return new Symbol(sym.head_a, yychar, yyline, yytext());}
"ENCABEZADO_FIN" {return new Symbol(sym.head_c, yychar, yyline, yytext());}
"TIT" {return new Symbol(sym.titulo, yychar, yyline, yytext());}
"CUERPO_INI" {return new Symbol(sym.body_a, yychar, yyline, yytext());}
"CUERPO_FIN" {return new Symbol(sym.body_c, yychar, yyline, yytext());}
"TABLA_INI" {return new Symbol(sym.table_a, yychar, yyline, yytext());}
"TABLA_FIN" {return new Symbol(sym.table_c, yychar, yyline, yytext());}
"FILA_INI" {return new Symbol(sym.row_a, yychar, yyline, yytext());}
"FILA_FIN" {return new Symbol(sym.row_c, yychar, yyline, yytext());}
"COLUMNA" {return new Symbol(sym.column, yychar, yyline, yytext());}
"IMAGEN_INI" {return new Symbol(sym.image_a, yychar, yyline, yytext());}
"*IMAGEN_FIN" {return new Symbol(sym.image_c, yychar, yyline, yytext());}
"LISTA_INI" {return new Symbol(sym.list_a, yychar, yyline, yytext());}
"*LISTA_FIN" {return new Symbol(sym.list_c, yychar, yyline, yytext());}
"ENLACE" {return new Symbol(sym.url, yychar, yyline, yytext());}
"BORDE" {return new Symbol(sym.border, yychar, yyline, yytext());}
"NOMBRE" {return new Symbol(sym.name, yychar, yyline, yytext());}
"ANCHO:" {return new Symbol(sym.width, yychar, yyline, yytext());}
"ALTURA:" {return new Symbol(sym.height, yychar, yyline, yytext());}
"NEGRITA" {return new Symbol(sym.bold_font, yychar, yyline, yytext());}
"IMPRIMIR" {return new Symbol(sym.print, yychar, yyline, yytext());}

"," {return new Symbol(sym.coma, yychar, yyline, yytext());}
"=" {return new Symbol(sym.igual, yychar, yyline, yytext());}
"(" {return new Symbol(sym.parentesis_a, yychar, yyline, yytext());}
")" {return new Symbol(sym.parentesis_c, yychar, yyline, yytext());}
";" {return new Symbol(sym.punto_coma, yychar, yyline, yytext());}
"+" {return new Symbol(sym.suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.producto, yychar, yyline, yytext());}
"/" {return new Symbol(sym.division, yychar, yyline, yytext());}


"\"" | "&quot;" {return new Symbol(sym.comillas, yychar, yyline, yytext());}
{correo} {return new Symbol(sym.email, yychar, yyline, yytext());}
{Pagina}|{Pagina}("/"{AlfaNumerico})+".html" {return new Symbol(sym.webpage, yychar, yyline, yytext());}
{D}+ {return new Symbol(sym.number_int, yychar, yyline, yytext());}
{D}+ "." {D}+ {return new Symbol(sym.number_float, yychar, yyline, yytext());}
{Elementos}  {return new Symbol(sym.dato, yychar, yyline, yytext());}



 . {return new Symbol(sym.error, yychar, yyline, yytext());}


