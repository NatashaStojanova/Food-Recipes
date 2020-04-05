import React from "react";

const Footer = () => {
    return (
        <footer className="font-small pt-4 mt-4">
            <br/> <br/>  <br/>  <br/>  <br/>
            <div className="footer-copyright text-center py-3">
                <div fluid>
                    &copy; {new Date().getFullYear()} Copyright: <a href="https://finki.ukim.mk/"> Faculty of Computer
                    Science and Engineering,
                    Skopje</a>
                    <br/>
                    <a href="https://github.com/NatashaStojanova">Natasha Stojanova</a>
                </div>
            </div>
        </footer>
    );
}

export default Footer;