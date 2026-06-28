import { useNavigate } from 'react-router-dom';
export default function AnswerScreen() { 
  const nav = useNavigate();
  return <div className="glass-card m-lg"><h2 className="text-primary mb-md">Interview In Progress</h2><button className="btn btn-primary" onClick={() => nav('/practice/summary')}>Finish Session</button></div>; 
}
