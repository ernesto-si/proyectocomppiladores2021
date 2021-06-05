package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens

L = [a-zA-Z]
D = [0-9]
AlfaNumerico=({L}+|{L}+{D}+)+
correo={AlfaNumerico}"@"{AlfaNumerico}"."({L}+|{L}+"."{L}+)
LU={AlfaNumerico} | [/.#=?-]
Pagina="www."{AlfaNumerico}"." ({L}+ | ({L}+ "/" {LU}+))
Elementos=({AlfaNumerico} | {AlfaNumerico} " " {AlfaNumerico})+

espacio=[ \t\r\n]+

%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/;}

"INI_HTML" {lexeme=yytext(); return html_a;}
"FIN_HTML" {lexeme=yytext(); return html_c;}
"ENCABEZADO_INI" {lexeme=yytext(); return head_a;}
"ENCABEZADO_FIN" {lexeme=yytext(); return head_c;}
"TIT" {lexeme=yytext(); return titulo;}
"CUERPO_INI" {lexeme=yytext(); return body_a;}
"CUERPO_FIN" {lexeme=yytext(); return body_c;}
"TABLA_INI" {lexeme=yytext(); return table_a;}
"TABLA_FIN" {lexeme=yytext(); return table_c;}
"FILA_INI" {lexeme=yytext(); return row_a;}
"FILA_FIN" {lexeme=yytext(); return row_c;}
"COLUMNA" {lexeme=yytext(); return column;}
"IMAGEN_INI" {lexeme=yytext(); return image_a;}
"*IMAGEN_FIN" {lexeme=yytext(); return image_c;}
"LISTA_INI" {lexeme=yytext(); return list_a;}
"*LISTA_FIN" {lexeme=yytext(); return list_c;}
"ENLACE" {lexeme=yytext(); return url;}
"BORDE" {lexeme=yytext(); return border;}
"NOMBRE" {lexeme=yytext(); return name;}
"ANCHO:" {lexeme=yytext(); return width;}
"ALTURA:" {lexeme=yytext(); return height;}
"NEGRITA" {lexeme=yytext(); return bold_font;}
"IMPRIMIR" {lexeme=yytext(); return print;}

"," {lexeme=yytext(); return coma;}
"=" {lexeme=yytext(); return igual;}
"(" {lexeme=yytext(); return parentesis_a;}
")" {lexeme=yytext(); return parentesis_c;}
";" {lexeme=yytext(); return punto_coma;}
"+" {lexeme=yytext(); return suma;}
"-" {lexeme=yytext(); return resta;}
"*" {lexeme=yytext(); return producto;}
"/" {lexeme=yytext(); return division;}


"\"" | "&quot;" {lexeme=yytext(); return comillas;}
{correo} {lexeme=yytext(); return email;}
{Pagina}|{Pagina}("/"{AlfaNumerico})+".html" {lexeme=yytext(); return webpage;}
{D}+ {lexeme=yytext(); return number_int;}
{D}+ "." {D}+ {lexeme=yytext(); return number_float;}
 {Elementos}  {lexeme=yytext(); return dato;}






 . {lexeme=yytext(); return error;}

