function setChecked() {
      var c = document.getElementsByName('userRow');
      if (!c[0].checked) c[0].checked = true;  // поставить checked на второй input, если он не установлен
    }
setChecked();