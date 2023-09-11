$(document).ready(function () {
      $(".btn-delete").on("click", function (e) {
        e.preventDefault();
        var href = $(this).attr('href');
		$("#delRef").attr('href',href)
        
        
        /*$("#yesBtn").attr("href", link.attr("href"));
        $("#confirmText").html("Do you want to delete the File: \<strong\>" + fileName + "\<\/strong\>?");*/
        $("#deleteModal").modal("show");
      });
      
      $("#closeRef").on("click", function (e) {
        e.preventDefault();
        $("#deleteModal").modal("hide");
      });
    });