import { useNavigate } from 'react-router-dom';
export default function SessionSummaryScreen() { 
  const nav = useNavigate();
  return <div className="glass-card m-lg"><h2 className="text-primary mb-md">Session Summary</h2><button className="btn btn-primary" onClick={() => nav('/match-score')}>View Match Score</button></div>; 
}
