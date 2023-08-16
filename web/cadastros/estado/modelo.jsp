<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
    
    
    <h2>Modelos</h2>
    <table id="datatable" class="display">
        <thead>
            <tr>
                <th align="left">ID</th>
                <th align="left">Descri��o</th>
                <th align="right"></th>
                <th align="right"></th>
            </tr>
            
        </thead>
        <tbody>
            <c:forEach var="modelo" items="${modelos}">
                <tr>
                    <td align="left">${modelo.idModelo}</td>
                    <td align="left">${modelo.descricao}</td>
                    <td align="center">
                        <a href=
                           "${pageContext.request.contextPath}/ModeloExcluir?idModelo=${modelo.idModelo}">
                            Excluir</a></td>
                            <td align="center">   
                                <a href=
                                   "${pageContext.request.contextPath}/ModeloCarregar?idModelo=${modelo.idModelo}">
                                    Alterar</a></td>       
                        </tr>
            </c:forEach>    
        </tbody>
        
    </table>
    
    <div align="center">
        <a href="${pageContext.request.contextPath}/ModeloNovo">Novo</a>
        <a href="index.jsp">Voltar � P�gina inicial</a>
    </div>
        
        <script>
            
            $(document).ready(function(){
              console.log('entrei ready');  
                $('#datatable').DataTable({
                   "oLanguage":{
                       "sProcessing": "Processando...",
                       "sLengthMenu": "Mostrar _MENU_registros", 
                       "sZeroRecords": "Nenhum registro encontrado.",
                       "sInfo": "Mostrando de _START_at� _END_de _TOTAL_registros",
                       "sInfoEmpty": "Mostrando de 0 at� 0 de 0 registros",
                       "sInfoFiltered": "",
                       "sInfoPostFix": "",
                       "sSearch": "Buscar:",
                       "sUrl": "",
                       
                       "oPaginate": {
                           "sFirst": "Primeiro",
                           "sPrevious": "Anterior",
                           "sNext": "Seguinte",
                           "sLast": "�ltimo"
                       }
                   }          
               });
            });     
        </script>
        
        <%@include file="/footer.jsp"%>



               