import Modal from "./components/Modal";
import RegisterForm from "./components/RegisterForm";

import Home from "./pages/Home";

const App = () => {
  return (
    <div>
      {/* <Home /> */}
      <Modal isOpen={true} title={"Register"}>
        <RegisterForm />
      </Modal>
    </div>
  );
};

export default App;
