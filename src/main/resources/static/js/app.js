document.addEventListener("DOMContentLoaded", function () {
  const loginForm = document.getElementById("loginForm");
  const addProductForm = document.getElementById("addProductForm");
  const updateProductForm = document.getElementById("updateProductForm");
  const backButton = document.getElementById("backButton");
  const userLoginForm = document.getElementById("userLoginForm");
  const userRegisterForm = document.getElementById("userRegisterForm");
  const registerButton = document.getElementById("registerSubmitButton");
  const form = document.getElementById("userRegisterForm");

  if (loginForm) {
    loginForm.addEventListener("submit", function (e) {
      e.preventDefault();
      const username = loginForm.username.value;
      const password = loginForm.password.value;
      if (username === "admin01" && password === "admin123") {
        localStorage.setItem("isAuthenticated", "true");
        window.location.href = "admin.html";
      } else {
        alert("Invalid username or password");
      }
    });
  }

  if (localStorage.getItem("isAuthenticated") !== "true" && !loginForm) {
    window.location.href = "login.html";
  }

  if (addProductForm) {
    addProductForm.addEventListener("submit", function (e) {
      e.preventDefault();
      const formData = new FormData(addProductForm);
      const product = {
        productName: formData.get("productName"),
        smallPrice: formData.get("smallPrice"),
        regularPrice: formData.get("regularPrice"),
        largePrice: formData.get("largePrice"),
      };
      fetch("/product/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(product),
      })
        .then((response) => response.text())
        .then((data) => {
          alert("Product added successfully!");
          window.location.href = "admin.html";
        });
    });
  }

  if (updateProductForm) {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get("id");
    fetch(`/product/Get_With_ID?productId=${productId}`)
      .then((response) => response.json())
      .then((product) => {
        document.getElementById("productId").value = product.productId;
        document.getElementById("productName").value = product.productName;
        document.getElementById("smallPrice").value = product.smallPrice;
        document.getElementById("regularPrice").value = product.regularPrice;
        document.getElementById("largePrice").value = product.largePrice;
      });

    updateProductForm.addEventListener("submit", function (e) {
      e.preventDefault();
      const formData = new FormData(updateProductForm);
      const updatedProduct = {
        productName: formData.get("productName"),
        smallPrice: formData.get("smallPrice"),
        regularPrice: formData.get("regularPrice"),
        largePrice: formData.get("largePrice"),
      };
      fetch(`/product/update_product/${productId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedProduct),
      })
        .then((response) => response.text())
        .then((data) => {
          alert("Product updated successfully!");
          window.location.href = "admin.html";
        });
    });
  }

  if (window.location.pathname.includes("delete.html")) {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get("id");
    fetch(`/product/Delete_product/${productId}`, {
      method: "DELETE",
    }).then(() => {
      alert("Product deleted successfully!");
      window.location.href = "admin.html";
    });
  }

  if (backButton) {
    backButton.addEventListener("click", function () {
      window.history.back();
    });
  }

  const productList = document.getElementById("productList");
  if (productList) {
    fetch("/product/get")
      .then((response) => response.json())
      .then((products) => {
        products.forEach((product) => {
          const li = document.createElement("li");
          li.innerHTML = `<strong>${product.productName}</strong><br>
                                Small: $${product.smallPrice}<br>
                                Regular: $${product.regularPrice}<br>
                                Large: $${product.largePrice}<br>
                                <button class="updateButton" data-id="${product.productId}">Update</button>
                                <button class="deleteButton" data-id="${product.productId}">Delete</button>`;
          productList.appendChild(li);
        });
      });
  }

  document.addEventListener("click", function (event) {
    if (event.target.classList.contains("updateButton")) {
      const productId = event.target.getAttribute("data-id");
      window.location.href = `update.html?id=${productId}`;
    }
  });

  document.addEventListener("click", function (event) {
    if (event.target.classList.contains("deleteButton")) {
      const productId = event.target.getAttribute("data-id");
      window.location.href = `delete.html?id=${productId}`;
    }
  });

  if (userRegisterForm) {
    userRegisterForm.addEventListener("submit", function (e) {
      e.preventDefault();
      const createPassword = userRegisterForm.elements["CreatePassword"];
      const confirmPassword = userRegisterForm.elements["ConfirmPassword"];

      if (createPassword.value !== confirmPassword.value) {
        alert("Passwords do not match. Please try again.");
      } else {
        const formData = new FormData(userRegisterForm);
        const user = {
          name: formData.get("name"),
          address: formData.get("address"),
          phoneNo: formData.get("phoneNo"),
          username: formData.get("username"),
          password: formData.get("CreatePassword"),
        };
        fetch("/user/add", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(user),
        })
          .then((response) => response.text())
          .then((data) => {
            alert("User added successfully!");
            window.location.href = "user.html";
          });
      }
    });
  }

  if (userLoginForm) {
    userLoginForm.addEventListener("submit", function (e) {
      e.preventDefault();
      const username = document.getElementById("username").value;
      const password = document.getElementById("password").value;

      fetch("/user/get")
        .then((response) => response.json())
        .then((users) => {
          const user = users.find(
            (u) => u.username === username && u.password === password
          );
          if (user) {
            alert("Login successful!");
            window.location.href = "user.html";
          } else {
            alert("Invalid username or password");
          }
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  }
});
