document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");

  const navClickHandler = (e) => {
    const target = e.target; // li

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      let URL = `${rootPath}` + targetClassName;
      const USER_URL = "login join mypage logout ulist";
      if (targetClassName === "home") {
        URL = `${rootPath}`;
      } else if (USER_URL.indexOf(targetClassName) > -1) {
        URL = `${rootPath}user/` + targetClassName;
      } else {
        URL = `${rootPath}` + targetClassName;
      }

      document.location.href = URL;
    }
  };

  nav?.addEventListener("click", navClickHandler);
});
