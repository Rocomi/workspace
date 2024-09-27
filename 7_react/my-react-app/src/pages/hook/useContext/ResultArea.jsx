import { useContext } from "react";
import { ResultContext } from "./UseContextHook";

function ResultArea({data}) {
    // {data} => props.data

    const ctx = useContext(ResultContext);
    return(
        <>
            <h3>{ctx}</h3>
        </>
    )
}
export default ResultArea;