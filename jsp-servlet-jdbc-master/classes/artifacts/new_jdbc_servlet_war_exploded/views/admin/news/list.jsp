<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-news"/>
<c:url var="NewURL" value="/admin-news"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
    <form action="<c:url  value='/admin-news'/>" id="formSubmit" method="get">
        <!-- //gọi vào phương thức doGet trong /admin-new -->
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">admin-home</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>

            <div class="page-content">

                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <!-- 	Sử dụng tooltip để hiện title khi user trỏ con trỏ chuột tới. -->
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip" title='Thêm bài viết'
                                           href='<c:url value="/admin-news?type=edit"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
                                        </a>
                                        <button id="btnDelete" type="button"
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <divclass
                "row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th><input type="checkbox" id="checkAll"></th>
                                <th>Tên bài viết</th>
                                <th>Mô tả ngắn</th>
                                <!-- <th>Thao tác</th> -->
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${model.listResult}">
                                <tr>
                                    <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                    <td>${item.title}</td>
                                    <td>${item.shortDescription}</td>
                                    <td>
                                        <c:url var="editURL" value="/admin-news">
                                            <c:param name="type" value="edit"/>
                                            <c:param name="id" value="${item.id}"/>
                                        </c:url>
                                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                           title="Cập nhật bài viết" href='${editURL}'><i class="fa fa-pencil-square-o"
                                                                                          aria-hidden="true"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <ul class="pagination" id="pagination"></ul>
                        <!-- để controller nhận đc giá trị page và maxPageItem thì ta cần khai báo biến name
                            id là dùng để cho funtion phân trang điều khiển -->
                        <input type="hidden" value="" id="page" name="page"/> <input
                            type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                        <input type="hidden" value="" id="sortName" name="sortName"/> <input
                            type="hidden" value="" id="sortBy" name="sortBy"/>
                        <input type="hidden" value="" id="type" name="type"/>
                    </div>
                </div>
            </div>
        </div>

</div>
</form>
</div>

<!-- /.main-content -->
<script>
    /* jquery phân trang để add giá trị cho <input > (chính là value) ở trên thì cần có cái cờ(flag) id để truyền giá trị value vào. */
    var totalPages = "${model.totalPage}";
    var currentPage = "${model.page}";
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('title');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });
    $("#btnDelete").click(function () {
        var data = {};
        //mảng ids dùng để lưu các giá trị có trong phần tbody bằng việc kiểm tra xem những id checkbox nào đã được tích rồi return về kết quả đó.
        var ids = $('tbody input[type=checkbox]:checkbox').map(function () {
            return $(this).val();
        }).get();
        //sau khi đã lây được danh sách cần xóa thì ta gọi hàm delete
        data['ids'] = ids;
        deleteNews(data);
    });

    function deleteNews(data) {
        $.ajax({    //jquery ajax
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json', //kiểu dữ liệu gửi từ client về server
            data: JSON.stringify(data), //chuyển đổi kiểu objectjquery sang kiểu JSON
            success: function (result) {
                window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=delete_success";
            },
            error: function (error) {
                window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
            },
        });
    }
</script>
</body>
</html>

<
