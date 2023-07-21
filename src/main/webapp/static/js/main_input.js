const ERROR_MESSAGE = {
  BCODE: "* 도서코드를 입력하세요",
  NAME: "* 도서명을 입력하세요",
  AUTHER: "* 저자명을 입력하세요",
  YEAR: "* 구입연도를 입력하세요",
  RPRICE: "* 대여가격을 입력하세요",
  USE: "* 대여유무를 입력하세요",
};

document.addEventListener("DOMContentLoaded", () => {
  const input_code = document.querySelector("#b_code");
  const input_name = document.querySelector("#b_name");
  const input_auther = document.querySelector("#b_auther");
  const input_year = document.querySelector("#b_year");
  const input_rprice = document.querySelector("#b_rprice");
  const input_use = document.querySelector("#b_use");

  const btn_save = document.querySelector("#btn_save");

  const err_box_list = document.querySelectorAll("div.error");
  const err_code = document.querySelector("div.error.code");
  const err_name = document.querySelector("div.error.name");
  const err_auther = document.querySelector("div.error.auther");
  const err_year = document.querySelector("div.error.year");
  const err_rprice = document.querySelector("div.error.rprice");
  const err_use = document.querySelector("div.error.use");

  const err_clear = () => {
    for (let box of err_box_list) {
      box?.classList.remove("on");
    }
  };

  const err_message = (e, err_box, message) => {
    const value = e.value;

    if (!value) {
      err_box.classList.add("on");
      err_box.innerHTML = message;
      e.select();
      return false;
    }
    return true;
  };

  input_name?.select();

  // input_code?.addEventListener("blur", async () => {
  //   err_clear();

  //   if (!err_message(input_code, err_code, ERROR_MESSAGE.BCODE)) {
  //     return false;
  //   }
  // });

  input_name?.addEventListener("blur", async () => {
    err_clear();
    if (!err_message(input_name, err_name, ERROR_MESSAGE.NAME)) {
      return false;
    }

    const name = input_name.value;

    const res = await fetch(`${rootPath}/name_check?name=${name}`);
    const json = await res.json();
    if (json.b_name === "NOT") {
      err_code.classList.add("on");
      err_code.innerHTML = "* 존재하는 도서명입니다";
      input_name.value = "";
      input_name.focus();
    }
  });

  input_auther?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_auther, err_auther, ERROR_MESSAGE.AUTHER)) {
      return false;
    }
  });

  input_year?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_year, err_year, ERROR_MESSAGE.YEAR)) {
      return false;
    }
  });

  input_rprice?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_rprice, err_rprice, ERROR_MESSAGE.RPRICE)) {
      return false;
    }
  });
  input_use?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_use, err_use, ERROR_MESSAGE.USE)) {
      return false;
    }
  });

  btn_save?.addEventListener("click", () => {
    if (
      err_message(input_code, err_code, ERROR_MESSAGE.BCODE) &&
      err_message(input_name, err_name, ERROR_MESSAGE.NAME) &&
      err_message(input_auther, err_auther, ERROR_MESSAGE.AUTHER) &&
      err_message(input_year, err_year, ERROR_MESSAGE.YEAR) &&
      err_message(input_rprice, err_rprice, ERROR_MESSAGE.RPRICE) &&
      err_message(input_use, err_use, ERROR_MESSAGE.USE)
    ) {
      document.querySelector("form.main").submit();
    }
    return false;
  });

  const form_book_update = document.querySelector("form.main.book.update");
  const form_user_update = document.querySelector("form.main.user.update");
  const b_btn_update = document.querySelector("#b_btn_update");
  const u_btn_update = document.querySelector("#u_btn_update");
  const blist_table = document.querySelector("table.main.book");
  const ulist_table = document.querySelector("table.main.user");

  blist_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const code = tr.dataset.id;
      document.location.href = `${rootPath}book_detail?code=${code}`;
    }
  });

  ulist_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const id = tr.dataset.id;
      document.location.href = `${rootPath}user/user_detail?id=${id}`;
    }
  });

  b_btn_update?.addEventListener("click", () => {
    form_book_update.submit();
  });

  u_btn_update?.addEventListener("click", () => {
    form_user_update.submit();
  });
});
