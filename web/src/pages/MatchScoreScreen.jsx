import { useNavigate } from 'react-router-dom';
export default function MatchScoreScreen() { 
  const nav = useNavigate();
  return <div className="glass-card m-lg"><h2 className="text-primary mb-md">Match Score</h2><button className="btn btn-primary" onClick={() => nav('/resume-rewrites')}>See Resume Rewrites</button></div>; 
}
