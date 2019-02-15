$('table').on('scroll', function () {
    $("#"+this.id+" > *").width($(this).width() + $(this).scrollLeft());
});
